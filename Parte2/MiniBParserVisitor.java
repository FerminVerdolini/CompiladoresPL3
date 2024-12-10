// Generated from MiniBParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniBParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniBParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniBParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(MiniBParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MiniBParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(MiniBParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MiniBParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MiniBParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(MiniBParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#inputStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputStatement(MiniBParser.InputStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#letStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetStatement(MiniBParser.LetStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#repeatStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatStatement(MiniBParser.RepeatStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#logicalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOp(MiniBParser.LogicalOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#bloqueControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloqueControl(MiniBParser.BloqueControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(MiniBParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MiniBParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(MiniBParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(MiniBParser.FactorContext ctx);
}