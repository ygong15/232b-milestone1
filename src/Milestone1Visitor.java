import java.io.File;
import java.lang.reflect.Array;
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
    public Milestone1Visitor(ArrayList<Node> nodes) {
        this.nodes = nodes;
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
        ArrayList<Node> startingnodes = new ArrayList<>();
        startingnodes.addAll(this.nodes);
        bfs(startingnodes,this.nodes);
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
        return super.visitRpText(ctx);
    }

    @Override
    public ArrayList<Node> visitRpCurr(XPathParser.RpCurrContext ctx) {
        return super.visitRpCurr(ctx);
    }

    @Override
    public ArrayList<Node> visitRpChildren(XPathParser.RpChildrenContext ctx) {
        return super.visitRpChildren(ctx);
    }

    @Override
    public ArrayList<Node> visitRpTag(XPathParser.RpTagContext ctx) {
        return super.visitRpTag(ctx);
    }

    @Override
    public ArrayList<Node> visitRpParen(XPathParser.RpParenContext ctx) {
        return super.visitRpParen(ctx);
    }

    @Override
    public ArrayList<Node> visitRpSlash(XPathParser.RpSlashContext ctx) {
        return super.visitRpSlash(ctx);
    }

    @Override
    public ArrayList<Node> visitRpDoubleslash(XPathParser.RpDoubleslashContext ctx) {
        return super.visitRpDoubleslash(ctx);
    }

    @Override
    public ArrayList<Node> visitRpBracket(XPathParser.RpBracketContext ctx) {
        return super.visitRpBracket(ctx);
    }

    @Override
    public ArrayList<Node> visitRpParenthesis(XPathParser.RpParenthesisContext ctx) {
        return super.visitRpParenthesis(ctx);
    }

    @Override
    public ArrayList<Node> visitRpAttr(XPathParser.RpAttrContext ctx) {
        return super.visitRpAttr(ctx);
    }

    @Override
    public ArrayList<Node> visitRpComma(XPathParser.RpCommaContext ctx) {
        return super.visitRpComma(ctx);
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
