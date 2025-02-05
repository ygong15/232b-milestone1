package main;

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


    //Filters
    @Override
    public ArrayList<Node> visitFilterAnd(XPathParser.FilterAndContext ctx) {
        System.out.println("visitFilterAnd: " + ctx.getText());
        HashSet<Node> left = new HashSet<>(visit(ctx.f(0)));
        HashSet<Node> right = new HashSet<>(visit(ctx.f(1)));
        HashSet<Node> result = new HashSet<>();

        for (Node n : left) {
            if (right.contains(n)) {
                result.add(n);
            }
        }

        this.nodes = new ArrayList<>(result);
        return this.nodes;
    }

    @Override
    public ArrayList<Node> visitFilterOr(XPathParser.FilterOrContext ctx) {
        System.out.println("visitFilterOr: " + ctx.getText());
        HashSet<Node> left = new HashSet<>(visit(ctx.f(0)));
        HashSet<Node> right = new HashSet<>(visit(ctx.f(1)));
        HashSet<Node> result = new HashSet<>(left);

        for (Node n : right) {
            result.add(n);
        }

        this.nodes = new ArrayList<>(result);
        return this.nodes;
    }

    @Override
    public ArrayList<Node> visitFilterNot(XPathParser.FilterNotContext ctx) {
        System.out.println("visitFilterNot: " + ctx.getText());
        HashSet<Node> allNodes = new HashSet<>(this.nodes);
        HashSet<Node> targetsToRemove = new HashSet<>(visit(ctx.f()));

        Iterator<Node> iterator = allNodes.iterator();
        while (iterator.hasNext()) {
            if (targetsToRemove.contains(iterator.next())) {
                iterator.remove();
            }
        }

        this.nodes = new ArrayList<>(allNodes);
        return this.nodes;
    }

    @Override
    public ArrayList<Node> visitFilterIs(XPathParser.FilterIsContext ctx) {
        System.out.println("visitFilterIs: " + ctx.getText());

        ArrayList<Node> result = new ArrayList<>();

        for (Node n : this.nodes) {
            ArrayList<Node> tempList = new ArrayList<>();
            tempList.add(n);
            this.nodes = tempList;
            ArrayList<Node> left = visit(ctx.rp(0));
            this.nodes = tempList;
            ArrayList<Node> right = visit(ctx.rp(1));

            for (Node l : left) {
                for (Node r : right) {
                    if (l.isSameNode(r)) { // 🔥 改成 isEqualNode()，保证匹配整个 XML 结构 //or if (l.getTextContent().equals(r.getTextContent())) {
                        result.add(n);
                        break;  // 找到匹配就退出，避免重复添加
                    }
                }
            }
        }

        this.nodes = result;
        return this.nodes;
    }


    @Override
    // One unsolved problem
    public ArrayList<Node> visitFilterEq(XPathParser.FilterEqContext ctx) {
        System.out.println("visitFilterEq: " + ctx.getText());
        ArrayList<Node> result = new ArrayList<>();

        for (Node n : this.nodes) {
            ArrayList<Node> tempList = new ArrayList<>();
            tempList.add(n);
            this.nodes = tempList;
            ArrayList<Node> left = visit(ctx.rp(0));
            this.nodes = tempList;
            ArrayList<Node> right = visit(ctx.rp(1));

            for (Node l : left) {
                for (Node r : right) {
                    if (l.isEqualNode(r)) { // 🔥 改成 isEqualNode()，保证匹配整个 XML 结构 //or if (l.getTextContent().equals(r.getTextContent())) {
                        result.add(n);
                        break;  // 找到匹配就退出，避免重复添加
                    }
                }
            }
        }

        this.nodes = result;
        return this.nodes;
    }


    @Override
    public ArrayList<Node> visitFilterRp(XPathParser.FilterRpContext ctx) {
        System.out.println("visitFilterRp: " + ctx.getText());

        ArrayList<Node> originalNodes = new ArrayList<>(this.nodes); // 备份
        ArrayList<Node> result = new ArrayList<>();

        for (Node n : originalNodes) {
            ArrayList<Node> tempNodes = new ArrayList<>(Collections.singletonList(n));
            this.nodes = tempNodes;
            if (!visit(ctx.rp()).isEmpty()) {
                result.add(n);
            }
        }
        this.nodes = result;
        return this.nodes;
    }

    @Override
    public ArrayList<Node> visitFilterConstStr(XPathParser.FilterConstStrContext ctx) {
        System.out.println("visitFilterConstStr: " + ctx.getText());
        ArrayList<Node> candidates = this.nodes;
        // 不知道要不要删掉双引号？？？存疑
        String str_const = ctx.stringConstant().getText().replace("\"", ""); // 去掉双引号
        HashSet<Node> result_set = new HashSet<>();

        for (Node cand : candidates) {
            this.nodes = new ArrayList<>(Collections.singletonList(cand)); // ✅ 修改 `this.nodes`

            ArrayList<Node> check_res = visit(ctx.rp());  // ✅ 计算 `rp()`

            for (Node res : check_res) {
                if (res.getTextContent().equals(str_const)) {
                    result_set.add(cand);  // ✅ `cand` 符合条件，加入 `result_set`
                    break;
                }
            }
        }

        this.nodes = new ArrayList<>(result_set);  // ✅ 更新 `this.nodes`
        return this.nodes;
    }

    @Override
    public ArrayList<Node> visitFilterParenthesis(XPathParser.FilterParenthesisContext ctx) {
        return visit(ctx.f());
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
