import java.io.File;
import java.util.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Milestone1Visitor extends XPathBaseVisitor<ArrayList<Node>> {
    /*
    store the current nodes under some level
     */
    private ArrayList<Node> nodes;

    /*
    constructor for the visitor
     */
    public Milestone1Visitor() {
        System.out.println("Calling milestone 1 constructor");
        this.nodes = new ArrayList<>();
    }

    /*
    helper function to generate all next nodes from an array of input nodes

    input: a list of nodes
    return: a list of nodes which are direct children of the list of input nodes
     */
    private ArrayList<Node> getNextLevelNodes(ArrayList<Node> inputNodes){
        ArrayList<Node> nextLevel = new ArrayList<>();
        for (Node iter : inputNodes) {
            NodeList curLevel = iter.getChildNodes();
            int len = curLevel.getLength();
            for (int i = 0; i < len; i++) {
                nextLevel.add(curLevel.item(i));
            }
        }
        return nextLevel;
    }

    /*
    helper function to perfrom bfs traversal on the XML tree

    input: a list of current nodes and a list for adding result nodes in
    return: null
     */
    private void bfs(ArrayList<Node> curr, ArrayList<Node> result) {
        if (curr == null || curr.isEmpty()) {
            return;
        }
        // add all current nodes
        result.addAll(curr);
        ArrayList<Node> nextLevel = getNextLevelNodes(curr);
        bfs(nextLevel, result);
    }

    /*
    visit immediate ap path
     */
    @Override
    public ArrayList<Node> visitApImmediate(XPathParser.ApImmediateContext ctx) {
        System.out.println("calling visit ap immediate");
        visit(ctx.doc());
        visit(ctx.rp());
        return this.nodes;
    }

    @Override
    public ArrayList<Node> visitApAll(XPathParser.ApAllContext ctx) {
        System.out.println("visitAp_all Called");
        System.out.println(ctx.getText());
        visit(ctx.doc());
        ArrayList<Node> startingNodes = new ArrayList<>();
        startingNodes.addAll(this.nodes);
        bfs(startingNodes,this.nodes);
        visit(ctx.rp());
        return this.nodes;
    }

    @Override
    public ArrayList<Node> visitDocument(XPathParser.DocumentContext ctx) {
        System.out.println("visitDocument Called :" + ctx.fileName().getText());

        String filename = ctx.fileName().getText();
        File targetFile = new File(filename);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder =  factory.newDocumentBuilder();
            Document doc = builder.parse(targetFile);
            nodes.add(doc);
        }catch (Exception e){
            System.out.println("Builder_Error");
        }
        return this.nodes;
    }

    @Override
    public ArrayList<Node> visitRpText(XPathParser.RpTextContext ctx) {
        System.out.println("visitRPText Called");
        ArrayList<Node> result = new ArrayList<>();
        ArrayList<Node> candidates = getNextLevelNodes(this.nodes);
        for (Node n: candidates) {
            if (n.getNodeType() == Node.TEXT_NODE) {
                result.add(n);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Node> visitRpCurr(XPathParser.RpCurrContext ctx) {
        // return what we have
        return this.nodes;
    }

    @Override
    public ArrayList<Node> visitRpChildren(XPathParser.RpChildrenContext ctx) {
        System.out.println("calling visit rp children");
        ArrayList<Node> res = new ArrayList<>();
        ArrayList<Node> candidates = getNextLevelNodes(this.nodes);
        for (Node node : candidates) {
            res.add(node);
        }
        // update class variable to the new res array
        this.nodes = res;
        return res;

    }

    @Override
    public ArrayList<Node> visitRpTag(XPathParser.RpTagContext ctx) {
        // extract tag name
        String name = ctx.tagName().getText();
        ArrayList<Node> res = new ArrayList<>();
        ArrayList<Node> candidates = getNextLevelNodes(this.nodes);
        for (Node node : candidates) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                if (node.getNodeName().equals(name)) {
                    res.add(node);
                }
            }
        }
        this.nodes = res;
        return res;
    }

    //TODO: When we visit a (rp) format
    @Override
    public ArrayList<Node> visitRpParen(XPathParser.RpParenContext ctx) {
        System.out.println("visitRp_parenthesis Called");
        System.out.println(ctx.rp().getText());
        return visit(ctx.rp());
    }

    @Override
    public ArrayList<Node> visitRpSlash(XPathParser.RpSlashContext ctx) {
        visit(ctx.rp(0));
        visit(ctx.rp(1));
        HashSet<Node> uniqueSet = new HashSet<Node>(this.nodes);
        this.nodes = new ArrayList<>(uniqueSet);
        return this.nodes;
    }

    @Override
    public ArrayList<Node> visitRpDoubleslash(XPathParser.RpDoubleslashContext ctx) {
        //first get into the context of rp1.
        visit(ctx.rp(0));
        //get all nodes below rp1 context.
        ArrayList<Node> startingNodes = new ArrayList<>();
        startingNodes.addAll(this.nodes);
        bfs(startingNodes,this.nodes);
        //select unique element
        HashSet<Node> uniqueSet = new HashSet<Node>(this.nodes);
        this.nodes = new ArrayList<>(uniqueSet);

        //now from current unique nodes context, check for rp2
        visit(ctx.rp(1));
        //Then select unique results from current context arraylist
        uniqueSet = new HashSet<Node>(this.nodes);
        this.nodes = new ArrayList<>(uniqueSet);
        return this.nodes;
    }

    @Override
    public ArrayList<Node> visitRpBracket(XPathParser.RpBracketContext ctx) {
        System.out.println("visitRp_bracket Called: " + ctx.getText());
        visit(ctx.rp());
        visit(ctx.f());
        return this.nodes;
    }

    //TODO: when we want to visit parent .. format
    @Override
    public ArrayList<Node> visitRpParenthesis(XPathParser.RpParenthesisContext ctx) {
        System.out.println("visitRp_parent Called");
        ArrayList<Node> parents = new ArrayList<>();
        for (Node child: this.nodes) {
            parents.add(child.getParentNode());
        }
        this.nodes = parents;
        return parents;
    }

    @Override
    public ArrayList<Node> visitRpAttr(XPathParser.RpAttrContext ctx) {
        System.out.println("visitRp_attr Called");
        String attName = ctx.attName().getText();
        ArrayList<Node> result = new ArrayList<>();
        ArrayList<Node> candidates = getNextLevelNodes(this.nodes);
        for (Node cand:candidates) {
            if (cand.getNodeType() == Node.ELEMENT_NODE){
                if (cand.getNodeName().equals(attName)){
                    result.add(cand);
                }
            }
        }
        this.nodes = result;
        return result;
    }

    @Override
    public ArrayList<Node> visitRpComma(XPathParser.RpCommaContext ctx) {
        System.out.println("Rp_comma Called");
        ArrayList<Node> result = new ArrayList<>();
        ArrayList<Node> originalNodes = this.nodes;
        //visit and store rp0
        visit(ctx.rp(0));
        ArrayList<Node> rp0 = this.nodes;
        //visit and store rp1
        this.nodes = originalNodes;
        visit(ctx.rp(1));
        ArrayList<Node> rp1 = this.nodes;
        //concatennate and return
        result.addAll(rp0);
        result.addAll(rp1);
        this.nodes = result;
        return result;
    }

    @Override
    public ArrayList<Node> visitFilterIs(XPathParser.FilterIsContext ctx) {
        return super.visitFilterIs(ctx);
    }

    @Override
    public ArrayList<Node> visitFilterRp(XPathParser.FilterRpContext ctx) {
        return super.visitFilterRp(ctx);
    }

    @Override
    public ArrayList<Node> visitFilterConstStr(XPathParser.FilterConstStrContext ctx) {
        return super.visitFilterConstStr(ctx);
    }

    @Override
    public ArrayList<Node> visitFilterEq(XPathParser.FilterEqContext ctx) {
        return super.visitFilterEq(ctx);
    }

    @Override
    public ArrayList<Node> visitFilterOr(XPathParser.FilterOrContext ctx) {
        return super.visitFilterOr(ctx);
    }

    @Override
    public ArrayList<Node> visitFilterAnd(XPathParser.FilterAndContext ctx) {
        return super.visitFilterAnd(ctx);
    }

    @Override
    public ArrayList<Node> visitFilterParenthesis(XPathParser.FilterParenthesisContext ctx) {
        return super.visitFilterParenthesis(ctx);
    }

    @Override
    public ArrayList<Node> visitFilterNot(XPathParser.FilterNotContext ctx) {
        return super.visitFilterNot(ctx);
    }

    @Override
    public ArrayList<Node> visitFileName(XPathParser.FileNameContext ctx) {
        return super.visitFileName(ctx);
    }

    @Override
    public ArrayList<Node> visitTagName(XPathParser.TagNameContext ctx) {
        return super.visitTagName(ctx);
    }

    @Override
    public ArrayList<Node> visitAttName(XPathParser.AttNameContext ctx) {
        return super.visitAttName(ctx);
    }

    @Override
    public ArrayList<Node> visitStringConstant(XPathParser.StringConstantContext ctx) {
        return super.visitStringConstant(ctx);
    }
}
