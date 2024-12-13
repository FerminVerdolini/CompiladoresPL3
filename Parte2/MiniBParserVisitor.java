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
	 * Visit a parse tree produced by {@link MiniBParser#resizeArrayStatemen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResizeArrayStatemen(MiniBParser.ResizeArrayStatemenContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(MiniBParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#subroutineDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubroutineDeclaration(MiniBParser.SubroutineDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(MiniBParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#subroutineCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubroutineCall(MiniBParser.SubroutineCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(MiniBParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(MiniBParser.ArgumentListContext ctx);
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
	 * Visit a parse tree produced by the {@code Numb}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumb(MiniBParser.NumbContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Flotante}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlotante(MiniBParser.FlotanteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Ident}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(MiniBParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parent}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParent(MiniBParser.ParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Cadena}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCadena(MiniBParser.CadenaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Car}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCar(MiniBParser.CarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(MiniBParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Val}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal(MiniBParser.ValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Len}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLen(MiniBParser.LenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Isnan}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsnan(MiniBParser.IsnanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Copy}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCopy(MiniBParser.CopyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Concat}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcat(MiniBParser.ConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SubStr}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubStr(MiniBParser.SubStrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CharAt}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharAt(MiniBParser.CharAtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayLit}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLit(MiniBParser.ArrayLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayAcc}
	 * labeled alternative in {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAcc(MiniBParser.ArrayAccContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#valFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValFunc(MiniBParser.ValFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#lenFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLenFunc(MiniBParser.LenFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#isNanFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsNanFunc(MiniBParser.IsNanFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#copyFunct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCopyFunct(MiniBParser.CopyFunctContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#subStringFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubStringFunc(MiniBParser.SubStringFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#concatFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatFunc(MiniBParser.ConcatFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#charAtFunct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharAtFunct(MiniBParser.CharAtFunctContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(MiniBParser.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(MiniBParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniBParser#boolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(MiniBParser.BooleanContext ctx);
}