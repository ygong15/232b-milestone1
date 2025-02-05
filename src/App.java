import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        //xpath filename
        String inputName = args[0];
        //evaluation results filename
        String outputName = args[1];

        XPathLexer lexer = new XPathLexer(CharStreams.fromFileName(inputName));
        ///XPathLexer lexer = new XPathLexer(CharStreams.fromString("doc(\"j_caesar.xml\")//PERSONA"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        //System.out.println(tokens.getText());
        //tokens.fill();
        //System.out.println(tokens.getText());
        XPathParser parser = new XPathParser(tokens);
        //parser.removeErrorListeners();
        // XPathParser.ApContext startRule = parser.ap();
        //System.out.println(startRule.toStringTree(parser));
        ParseTree tree = parser.ap();
        Milestone1Visitor m1_visitor = new Milestone1Visitor();

        System.out.println("App Visits Starts");
        ArrayList<Node> results = m1_visitor.visit(tree);
        System.out.println("App Visits Finishs");

        System.out.println("Visits result size: " + results.size());
        DocumentBuilderFactory facotry = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = facotry.newDocumentBuilder();
        Document doc = builder.newDocument();

        Node root_Node = doc.createElement("Result");
        for (Node node : results) {
            Node copy = doc.importNode(node,true);
            root_Node.appendChild(copy);
        }
        doc.appendChild(root_Node);

        // Generate output xml file
        TransformerFactory tfFactory = TransformerFactory.newInstance();
        Transformer transformer = tfFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "");
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.OMIT_XML_DECLARATION, "yes");
        DOMSource source = new DOMSource(doc);
        String filePath = outputName;
        StreamResult result = new StreamResult(filePath);
        transformer.transform(source, result);

        Transformer transformer_nl = tfFactory.newTransformer();
        transformer_nl.setOutputProperty(OutputKeys.INDENT, "Yes");
        transformer_nl.setOutputProperty(javax.xml.transform.OutputKeys.OMIT_XML_DECLARATION, "yes");
        String filePath_nl = outputName+ "_with_new_line";
        StreamResult result_nl = new StreamResult(filePath_nl);
        transformer_nl.transform(source, result_nl);
    }
}
