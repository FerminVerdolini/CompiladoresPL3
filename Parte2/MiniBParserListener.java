// Generated from MiniBParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniBParser}.
 */
public interface MiniBParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniBParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(MiniBParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(MiniBParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniBParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniBParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MiniBParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MiniBParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MiniBParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MiniBParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MiniBParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MiniBParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(MiniBParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(MiniBParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#inputStatement}.
	 * @param ctx the parse tree
	 */
	void enterInputStatement(MiniBParser.InputStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#inputStatement}.
	 * @param ctx the parse tree
	 */
	void exitInputStatement(MiniBParser.InputStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#letStatement}.
	 * @param ctx the parse tree
	 */
	void enterLetStatement(MiniBParser.LetStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#letStatement}.
	 * @param ctx the parse tree
	 */
	void exitLetStatement(MiniBParser.LetStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void enterRepeatStatement(MiniBParser.RepeatStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void exitRepeatStatement(MiniBParser.RepeatStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOp(MiniBParser.LogicalOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOp(MiniBParser.LogicalOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#bloqueControl}.
	 * @param ctx the parse tree
	 */
	void enterBloqueControl(MiniBParser.BloqueControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#bloqueControl}.
	 * @param ctx the parse tree
	 */
	void exitBloqueControl(MiniBParser.BloqueControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(MiniBParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(MiniBParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MiniBParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MiniBParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(MiniBParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(MiniBParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Numb}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterNumb(MiniBParser.NumbContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Numb}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitNumb(MiniBParser.NumbContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Ident}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterIdent(MiniBParser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Ident}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitIdent(MiniBParser.IdentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterParent(MiniBParser.ParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitParent(MiniBParser.ParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Cadena}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterCadena(MiniBParser.CadenaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Cadena}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitCadena(MiniBParser.CadenaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Val}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterVal(MiniBParser.ValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Val}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitVal(MiniBParser.ValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Len}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterLen(MiniBParser.LenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Len}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitLen(MiniBParser.LenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Isnan}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterIsnan(MiniBParser.IsnanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Isnan}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitIsnan(MiniBParser.IsnanContext ctx);
}