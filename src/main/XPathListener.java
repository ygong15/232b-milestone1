package main;// Generated from XPath.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPathParser}.
 */
public interface XPathListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code apImmediate}
	 * labeled alternative in {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterApImmediate(XPathParser.ApImmediateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code apImmediate}
	 * labeled alternative in {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitApImmediate(XPathParser.ApImmediateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code apAll}
	 * labeled alternative in {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterApAll(XPathParser.ApAllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code apAll}
	 * labeled alternative in {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitApAll(XPathParser.ApAllContext ctx);
	/**
	 * Enter a parse tree produced by the {@code document}
	 * labeled alternative in {@link XPathParser#doc}.
	 * @param ctx the parse tree
	 */
	void enterDocument(XPathParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code document}
	 * labeled alternative in {@link XPathParser#doc}.
	 * @param ctx the parse tree
	 */
	void exitDocument(XPathParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpText}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpText(XPathParser.RpTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpText}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpText(XPathParser.RpTextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpCurr}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpCurr(XPathParser.RpCurrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpCurr}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpCurr(XPathParser.RpCurrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpChildren}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpChildren(XPathParser.RpChildrenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpChildren}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpChildren(XPathParser.RpChildrenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpTag}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpTag(XPathParser.RpTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpTag}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpTag(XPathParser.RpTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpParen}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpParen(XPathParser.RpParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpParen}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpParen(XPathParser.RpParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpSlash}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpSlash(XPathParser.RpSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpSlash}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpSlash(XPathParser.RpSlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpDoubleslash}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpDoubleslash(XPathParser.RpDoubleslashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpDoubleslash}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpDoubleslash(XPathParser.RpDoubleslashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpBracket}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpBracket(XPathParser.RpBracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpBracket}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpBracket(XPathParser.RpBracketContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpParenthesis}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpParenthesis(XPathParser.RpParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpParenthesis}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpParenthesis(XPathParser.RpParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpAttr}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpAttr(XPathParser.RpAttrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpAttr}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpAttr(XPathParser.RpAttrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpComma}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpComma(XPathParser.RpCommaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpComma}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpComma(XPathParser.RpCommaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code filterIs}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFilterIs(XPathParser.FilterIsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code filterIs}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFilterIs(XPathParser.FilterIsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code filterRp}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFilterRp(XPathParser.FilterRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code filterRp}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFilterRp(XPathParser.FilterRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code filterConstStr}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFilterConstStr(XPathParser.FilterConstStrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code filterConstStr}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFilterConstStr(XPathParser.FilterConstStrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code filterEq}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFilterEq(XPathParser.FilterEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code filterEq}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFilterEq(XPathParser.FilterEqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code filterOr}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFilterOr(XPathParser.FilterOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code filterOr}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFilterOr(XPathParser.FilterOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code filterAnd}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFilterAnd(XPathParser.FilterAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code filterAnd}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFilterAnd(XPathParser.FilterAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code filterParenthesis}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFilterParenthesis(XPathParser.FilterParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code filterParenthesis}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFilterParenthesis(XPathParser.FilterParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code filterNot}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterFilterNot(XPathParser.FilterNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code filterNot}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitFilterNot(XPathParser.FilterNotContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#fileName}.
	 * @param ctx the parse tree
	 */
	void enterFileName(XPathParser.FileNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#fileName}.
	 * @param ctx the parse tree
	 */
	void exitFileName(XPathParser.FileNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(XPathParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(XPathParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#attName}.
	 * @param ctx the parse tree
	 */
	void enterAttName(XPathParser.AttNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#attName}.
	 * @param ctx the parse tree
	 */
	void exitAttName(XPathParser.AttNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#stringConstant}.
	 * @param ctx the parse tree
	 */
	void enterStringConstant(XPathParser.StringConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#stringConstant}.
	 * @param ctx the parse tree
	 */
	void exitStringConstant(XPathParser.StringConstantContext ctx);
}