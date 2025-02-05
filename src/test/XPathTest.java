package test;
import main.Milestone1Visitor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import main.XPathParser;
import org.junit.jupiter.api.Test;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.*;

class XPathTest {
    private Document createXMLDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        // 创建 <bookstore> 根节点
        Element root = doc.createElement("bookstore");
        doc.appendChild(root);

        // 创建 <book><price>30</price></book>
        Element book1 = doc.createElement("book");
        Element price1 = doc.createElement("price");
        price1.setTextContent("30");
        book1.appendChild(price1);
        root.appendChild(book1);

        // 创建 <book><price>40</price></book>
        Element book2 = doc.createElement("book");
        Element price2 = doc.createElement("price");
        price2.setTextContent("40");
        book2.appendChild(price2);
        root.appendChild(book2);

        return doc;
    }

    @Test
    void testVisitFilterAnd() throws Exception {
        Document doc = createXMLDocument();

        Node commonNode = mock(Node.class);
        when(commonNode.getTextContent()).thenReturn("30");

        ArrayList<Node> price30 = new ArrayList<>();
        ArrayList<Node> price40 = new ArrayList<>();
        price30.add(commonNode);
        price40.add(commonNode);  // 让 AND 有交集

        XPathParser.FilterAndContext ctx = mock(XPathParser.FilterAndContext.class);
        when(ctx.f(0)).thenReturn(mock(XPathParser.FContext.class));
        when(ctx.f(1)).thenReturn(mock(XPathParser.FContext.class));

        Milestone1Visitor realVisitor = new Milestone1Visitor(new ArrayList<>(price30));
        Milestone1Visitor visitor = spy(realVisitor);

        doReturn(price30).when(visitor).visit(ctx.f(0));
        doReturn(price40).when(visitor).visit(ctx.f(1));

        ArrayList<Node> result = visitor.visitFilterAnd(ctx);
        assertEquals(1, result.size(), "AND 逻辑应该返回 1 个节点");
    }

    @Test
    void testVisitFilterNot() throws Exception {
        Node node30 = mock(Node.class);
        when(node30.getTextContent()).thenReturn("30");
        Node node40 = mock(Node.class);
        when(node40.getTextContent()).thenReturn("40");

        ArrayList<Node> allNodes = new ArrayList<>();
        allNodes.add(node30);
        allNodes.add(node40);

        XPathParser.FilterNotContext ctx = mock(XPathParser.FilterNotContext.class);
        when(ctx.f()).thenReturn(mock(XPathParser.FContext.class));

        Milestone1Visitor realVisitor = new Milestone1Visitor(new ArrayList<>(allNodes));
        Milestone1Visitor visitor = spy(realVisitor);

        doReturn(new ArrayList<>(List.of(node30))).when(visitor).visit(ctx.f());

        ArrayList<Node> result = visitor.visitFilterNot(ctx);
        assertEquals(1, result.size(), "NOT 逻辑应该排除 `30`，只剩 `40`");
        assertEquals("40", result.get(0).getTextContent(), "剩下的应该是 `40`");
    }
}
