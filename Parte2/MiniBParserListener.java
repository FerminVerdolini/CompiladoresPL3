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
	 * Enter a parse tree produced by {@link MiniBParser#resizeArrayStatemen}.
	 * @param ctx the parse tree
	 */
	void enterResizeArrayStatemen(MiniBParser.ResizeArrayStatemenContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#resizeArrayStatemen}.
	 * @param ctx the parse tree
	 */
	void exitResizeArrayStatemen(MiniBParser.ResizeArrayStatemenContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(MiniBParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(MiniBParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#subroutineDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSubroutineDeclaration(MiniBParser.SubroutineDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#subroutineDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSubroutineDeclaration(MiniBParser.SubroutineDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(MiniBParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(MiniBParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#subroutineCall}.
	 * @param ctx the parse tree
	 */
	void enterSubroutineCall(MiniBParser.SubroutineCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#subroutineCall}.
	 * @param ctx the parse tree
	 */
	void exitSubroutineCall(MiniBParser.SubroutineCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(MiniBParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(MiniBParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(MiniBParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(MiniBParser.ArgumentListContext ctx);
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
	 * Enter a parse tree produced by {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(MiniBParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(MiniBParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#valFunc}.
	 * @param ctx the parse tree
	 */
	void enterValFunc(MiniBParser.ValFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#valFunc}.
	 * @param ctx the parse tree
	 */
	void exitValFunc(MiniBParser.ValFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#lenFunc}.
	 * @param ctx the parse tree
	 */
	void enterLenFunc(MiniBParser.LenFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#lenFunc}.
	 * @param ctx the parse tree
	 */
	void exitLenFunc(MiniBParser.LenFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#isNanFunc}.
	 * @param ctx the parse tree
	 */
	void enterIsNanFunc(MiniBParser.IsNanFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#isNanFunc}.
	 * @param ctx the parse tree
	 */
	void exitIsNanFunc(MiniBParser.IsNanFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#copyFunct}.
	 * @param ctx the parse tree
	 */
	void enterCopyFunct(MiniBParser.CopyFunctContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#copyFunct}.
	 * @param ctx the parse tree
	 */
	void exitCopyFunct(MiniBParser.CopyFunctContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#subStringFunc}.
	 * @param ctx the parse tree
	 */
	void enterSubStringFunc(MiniBParser.SubStringFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#subStringFunc}.
	 * @param ctx the parse tree
	 */
	void exitSubStringFunc(MiniBParser.SubStringFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#concatFunc}.
	 * @param ctx the parse tree
	 */
	void enterConcatFunc(MiniBParser.ConcatFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#concatFunc}.
	 * @param ctx the parse tree
	 */
	void exitConcatFunc(MiniBParser.ConcatFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#charAtFunct}.
	 * @param ctx the parse tree
	 */
	void enterCharAtFunct(MiniBParser.CharAtFunctContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#charAtFunct}.
	 * @param ctx the parse tree
	 */
	void exitCharAtFunct(MiniBParser.CharAtFunctContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(MiniBParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(MiniBParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(MiniBParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(MiniBParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniBParser#boolean}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(MiniBParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniBParser#boolean}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(MiniBParser.BooleanContext ctx);
}