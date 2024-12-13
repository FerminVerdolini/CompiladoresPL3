// Generated from MiniBParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MiniBParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FOR=1, TO=2, NEXT=3, IF=4, THEN=5, ELSE=6, WHILE=7, DO=8, END=9, PRINT=10, 
		INPUT=11, LET=12, MOD=13, CONTINUE=14, EXIT=15, REPEAT=16, UNTIL=17, VAL=18, 
		LEN=19, ISNAN=20, COPY=21, CONCAT=22, SUBSTRING=23, CHARAT=24, RESIZE=25, 
		FUNCTION=26, RETURN=27, SUB=28, CALL=29, EQUAL=30, PLUS=31, MINUS=32, 
		MULT=33, DIV=34, LT=35, LTE=36, GT=37, GTE=38, EQ=39, NEQ=40, LPAREN=41, 
		RPAREN=42, LBRACKET=43, RBRACKET=44, COMMA=45, QUOTE=46, AND=47, OR=48, 
		NOT=49, TRUE=50, FALSE=51, IDENTIFIER=52, NUMBER=53, STRING=54, CHAR=55, 
		FLOAT=56, WS=57, COMMENT=58;
	public static final int
		RULE_programa = 0, RULE_statement = 1, RULE_forStatement = 2, RULE_ifStatement = 3, 
		RULE_whileStatement = 4, RULE_printStatement = 5, RULE_inputStatement = 6, 
		RULE_letStatement = 7, RULE_repeatStatement = 8, RULE_resizeArrayStatemen = 9, 
		RULE_functionDeclaration = 10, RULE_subroutineDeclaration = 11, RULE_functionCall = 12, 
		RULE_subroutineCall = 13, RULE_parameterList = 14, RULE_argumentList = 15, 
		RULE_logicalOp = 16, RULE_bloqueControl = 17, RULE_condition = 18, RULE_expression = 19, 
		RULE_term = 20, RULE_factor = 21, RULE_valFunc = 22, RULE_lenFunc = 23, 
		RULE_isNanFunc = 24, RULE_copyFunct = 25, RULE_subStringFunc = 26, RULE_concatFunc = 27, 
		RULE_charAtFunct = 28, RULE_arrayLiteral = 29, RULE_arrayAccess = 30, 
		RULE_boolean = 31, RULE_factorOperations = 32, RULE_expOperations = 33;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "statement", "forStatement", "ifStatement", "whileStatement", 
			"printStatement", "inputStatement", "letStatement", "repeatStatement", 
			"resizeArrayStatemen", "functionDeclaration", "subroutineDeclaration", 
			"functionCall", "subroutineCall", "parameterList", "argumentList", "logicalOp", 
			"bloqueControl", "condition", "expression", "term", "factor", "valFunc", 
			"lenFunc", "isNanFunc", "copyFunct", "subStringFunc", "concatFunc", "charAtFunct", 
			"arrayLiteral", "arrayAccess", "boolean", "factorOperations", "expOperations"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "'='", "'+'", "'-'", "'*'", "'/'", 
			"'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'('", "')'", "'['", "']'", 
			"','", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FOR", "TO", "NEXT", "IF", "THEN", "ELSE", "WHILE", "DO", "END", 
			"PRINT", "INPUT", "LET", "MOD", "CONTINUE", "EXIT", "REPEAT", "UNTIL", 
			"VAL", "LEN", "ISNAN", "COPY", "CONCAT", "SUBSTRING", "CHARAT", "RESIZE", 
			"FUNCTION", "RETURN", "SUB", "CALL", "EQUAL", "PLUS", "MINUS", "MULT", 
			"DIV", "LT", "LTE", "GT", "GTE", "EQ", "NEQ", "LPAREN", "RPAREN", "LBRACKET", 
			"RBRACKET", "COMMA", "QUOTE", "AND", "OR", "NOT", "TRUE", "FALSE", "IDENTIFIER", 
			"NUMBER", "STRING", "CHAR", "FLOAT", "WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MiniBParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniBParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68);
				statement();
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4503600533413010L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public InputStatementContext inputStatement() {
			return getRuleContext(InputStatementContext.class,0);
		}
		public LetStatementContext letStatement() {
			return getRuleContext(LetStatementContext.class,0);
		}
		public RepeatStatementContext repeatStatement() {
			return getRuleContext(RepeatStatementContext.class,0);
		}
		public ResizeArrayStatemenContext resizeArrayStatemen() {
			return getRuleContext(ResizeArrayStatemenContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public SubroutineDeclarationContext subroutineDeclaration() {
			return getRuleContext(SubroutineDeclarationContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public SubroutineCallContext subroutineCall() {
			return getRuleContext(SubroutineCallContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				forStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				ifStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				whileStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				printStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(77);
				inputStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(78);
				letStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(79);
				repeatStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(80);
				resizeArrayStatemen();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(81);
				functionDeclaration();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(82);
				subroutineDeclaration();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(83);
				functionCall();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(84);
				subroutineCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MiniBParser.FOR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MiniBParser.IDENTIFIER, 0); }
		public TerminalNode EQUAL() { return getToken(MiniBParser.EQUAL, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode TO() { return getToken(MiniBParser.TO, 0); }
		public BloqueControlContext bloqueControl() {
			return getRuleContext(BloqueControlContext.class,0);
		}
		public TerminalNode NEXT() { return getToken(MiniBParser.NEXT, 0); }
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(FOR);
			setState(88);
			match(IDENTIFIER);
			setState(89);
			match(EQUAL);
			setState(90);
			expression();
			setState(91);
			match(TO);
			setState(92);
			expression();
			setState(93);
			bloqueControl();
			setState(94);
			match(NEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiniBParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(MiniBParser.THEN, 0); }
		public List<BloqueControlContext> bloqueControl() {
			return getRuleContexts(BloqueControlContext.class);
		}
		public BloqueControlContext bloqueControl(int i) {
			return getRuleContext(BloqueControlContext.class,i);
		}
		public TerminalNode END() { return getToken(MiniBParser.END, 0); }
		public TerminalNode ELSE() { return getToken(MiniBParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(IF);
			setState(97);
			condition();
			setState(98);
			match(THEN);
			setState(99);
			bloqueControl();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(100);
				match(ELSE);
				setState(101);
				bloqueControl();
				}
			}

			setState(104);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiniBParser.WHILE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BloqueControlContext bloqueControl() {
			return getRuleContext(BloqueControlContext.class,0);
		}
		public TerminalNode END() { return getToken(MiniBParser.END, 0); }
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(WHILE);
			setState(107);
			condition();
			setState(108);
			bloqueControl();
			setState(109);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintStatementContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(MiniBParser.PRINT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitPrintStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitPrintStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(PRINT);
			setState(112);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InputStatementContext extends ParserRuleContext {
		public TerminalNode INPUT() { return getToken(MiniBParser.INPUT, 0); }
		public TerminalNode STRING() { return getToken(MiniBParser.STRING, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MiniBParser.IDENTIFIER, 0); }
		public InputStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterInputStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitInputStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitInputStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputStatementContext inputStatement() throws RecognitionException {
		InputStatementContext _localctx = new InputStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_inputStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(INPUT);
			setState(115);
			match(STRING);
			setState(116);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LetStatementContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MiniBParser.IDENTIFIER, 0); }
		public TerminalNode EQUAL() { return getToken(MiniBParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LET() { return getToken(MiniBParser.LET, 0); }
		public LetStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterLetStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitLetStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitLetStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetStatementContext letStatement() throws RecognitionException {
		LetStatementContext _localctx = new LetStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_letStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LET) {
				{
				setState(118);
				match(LET);
				}
			}

			setState(121);
			match(IDENTIFIER);
			setState(122);
			match(EQUAL);
			setState(123);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RepeatStatementContext extends ParserRuleContext {
		public TerminalNode REPEAT() { return getToken(MiniBParser.REPEAT, 0); }
		public TerminalNode UNTIL() { return getToken(MiniBParser.UNTIL, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public RepeatStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterRepeatStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitRepeatStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitRepeatStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatStatementContext repeatStatement() throws RecognitionException {
		RepeatStatementContext _localctx = new RepeatStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_repeatStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(REPEAT);
			setState(127); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(126);
				statement();
				}
				}
				setState(129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4503600533413010L) != 0) );
			setState(131);
			match(UNTIL);
			setState(132);
			condition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ResizeArrayStatemenContext extends ParserRuleContext {
		public TerminalNode RESIZE() { return getToken(MiniBParser.RESIZE, 0); }
		public TerminalNode LPAREN() { return getToken(MiniBParser.LPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MiniBParser.IDENTIFIER, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MiniBParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniBParser.COMMA, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(MiniBParser.RPAREN, 0); }
		public ResizeArrayStatemenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resizeArrayStatemen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterResizeArrayStatemen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitResizeArrayStatemen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitResizeArrayStatemen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResizeArrayStatemenContext resizeArrayStatemen() throws RecognitionException {
		ResizeArrayStatemenContext _localctx = new ResizeArrayStatemenContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_resizeArrayStatemen);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(RESIZE);
			setState(135);
			match(LPAREN);
			setState(136);
			match(IDENTIFIER);
			setState(137);
			match(COMMA);
			setState(138);
			expression();
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(139);
				match(COMMA);
				setState(140);
				expression();
				}
			}

			setState(143);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> FUNCTION() { return getTokens(MiniBParser.FUNCTION); }
		public TerminalNode FUNCTION(int i) {
			return getToken(MiniBParser.FUNCTION, i);
		}
		public TerminalNode IDENTIFIER() { return getToken(MiniBParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(MiniBParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MiniBParser.RPAREN, 0); }
		public BloqueControlContext bloqueControl() {
			return getRuleContext(BloqueControlContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(MiniBParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode END() { return getToken(MiniBParser.END, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(FUNCTION);
			setState(146);
			match(IDENTIFIER);
			setState(147);
			match(LPAREN);
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(148);
				parameterList();
				}
			}

			setState(151);
			match(RPAREN);
			setState(152);
			bloqueControl();
			setState(153);
			match(RETURN);
			setState(154);
			expression();
			setState(155);
			match(END);
			setState(156);
			match(FUNCTION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubroutineDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> SUB() { return getTokens(MiniBParser.SUB); }
		public TerminalNode SUB(int i) {
			return getToken(MiniBParser.SUB, i);
		}
		public TerminalNode IDENTIFIER() { return getToken(MiniBParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(MiniBParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MiniBParser.RPAREN, 0); }
		public BloqueControlContext bloqueControl() {
			return getRuleContext(BloqueControlContext.class,0);
		}
		public TerminalNode END() { return getToken(MiniBParser.END, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public SubroutineDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subroutineDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterSubroutineDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitSubroutineDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitSubroutineDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubroutineDeclarationContext subroutineDeclaration() throws RecognitionException {
		SubroutineDeclarationContext _localctx = new SubroutineDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_subroutineDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(SUB);
			setState(159);
			match(IDENTIFIER);
			setState(160);
			match(LPAREN);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(161);
				parameterList();
				}
			}

			setState(164);
			match(RPAREN);
			setState(165);
			bloqueControl();
			setState(166);
			match(END);
			setState(167);
			match(SUB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MiniBParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(MiniBParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MiniBParser.RPAREN, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(IDENTIFIER);
			setState(170);
			match(LPAREN);
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 143000283318583296L) != 0)) {
				{
				setState(171);
				argumentList();
				}
			}

			setState(174);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubroutineCallContext extends ParserRuleContext {
		public TerminalNode CALL() { return getToken(MiniBParser.CALL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MiniBParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(MiniBParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MiniBParser.RPAREN, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public SubroutineCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subroutineCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterSubroutineCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitSubroutineCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitSubroutineCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubroutineCallContext subroutineCall() throws RecognitionException {
		SubroutineCallContext _localctx = new SubroutineCallContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_subroutineCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(CALL);
			setState(177);
			match(IDENTIFIER);
			setState(178);
			match(LPAREN);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 143000283318583296L) != 0)) {
				{
				setState(179);
				argumentList();
				}
			}

			setState(182);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(MiniBParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MiniBParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniBParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniBParser.COMMA, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(IDENTIFIER);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(185);
				match(COMMA);
				setState(186);
				match(IDENTIFIER);
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniBParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniBParser.COMMA, i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			expression();
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(193);
				match(COMMA);
				setState(194);
				expression();
				}
				}
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOpContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(MiniBParser.AND, 0); }
		public TerminalNode OR() { return getToken(MiniBParser.OR, 0); }
		public TerminalNode NOT() { return getToken(MiniBParser.NOT, 0); }
		public LogicalOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterLogicalOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitLogicalOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitLogicalOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalOpContext logicalOp() throws RecognitionException {
		LogicalOpContext _localctx = new LogicalOpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_logicalOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 985162418487296L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BloqueControlContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(MiniBParser.CONTINUE, 0); }
		public TerminalNode EXIT() { return getToken(MiniBParser.EXIT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BloqueControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloqueControl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterBloqueControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitBloqueControl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitBloqueControl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BloqueControlContext bloqueControl() throws RecognitionException {
		BloqueControlContext _localctx = new BloqueControlContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_bloqueControl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
			case IF:
			case WHILE:
			case PRINT:
			case INPUT:
			case LET:
			case REPEAT:
			case RESIZE:
			case FUNCTION:
			case SUB:
			case CALL:
			case IDENTIFIER:
				{
				setState(203); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(202);
					statement();
					}
					}
					setState(205); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4503600533413010L) != 0) );
				}
				break;
			case CONTINUE:
				{
				setState(207);
				match(CONTINUE);
				}
				break;
			case EXIT:
				{
				setState(208);
				match(EXIT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LogicalOpContext logicalOp() {
			return getRuleContext(LogicalOpContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode LT() { return getToken(MiniBParser.LT, 0); }
		public TerminalNode LTE() { return getToken(MiniBParser.LTE, 0); }
		public TerminalNode GT() { return getToken(MiniBParser.GT, 0); }
		public TerminalNode GTE() { return getToken(MiniBParser.GTE, 0); }
		public TerminalNode EQ() { return getToken(MiniBParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MiniBParser.NEQ, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			expression();
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2164663517184L) != 0)) {
				{
				setState(212);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2164663517184L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(213);
				expression();
				}
			}

			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 985162418487296L) != 0)) {
				{
				setState(216);
				logicalOp();
				setState(217);
				condition();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<ExpOperationsContext> expOperations() {
			return getRuleContexts(ExpOperationsContext.class);
		}
		public ExpOperationsContext expOperations(int i) {
			return getRuleContext(ExpOperationsContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			term();
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(222);
				expOperations();
				setState(223);
				term();
				}
				}
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<FactorOperationsContext> factorOperations() {
			return getRuleContexts(FactorOperationsContext.class);
		}
		public FactorOperationsContext factorOperations(int i) {
			return getRuleContext(FactorOperationsContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			factor();
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 25769811968L) != 0)) {
				{
				{
				setState(231);
				factorOperations();
				setState(232);
				factor();
				}
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValContext extends FactorContext {
		public ValFuncContext valFunc() {
			return getRuleContext(ValFuncContext.class,0);
		}
		public ValContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAccContext extends FactorContext {
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public ArrayAccContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterArrayAcc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitArrayAcc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitArrayAcc(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentContext extends FactorContext {
		public TerminalNode IDENTIFIER() { return getToken(MiniBParser.IDENTIFIER, 0); }
		public IdentContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FlotanteContext extends FactorContext {
		public TerminalNode FLOAT() { return getToken(MiniBParser.FLOAT, 0); }
		public FlotanteContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterFlotante(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitFlotante(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitFlotante(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParentContext extends FactorContext {
		public TerminalNode LPAREN() { return getToken(MiniBParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniBParser.RPAREN, 0); }
		public ParentContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterParent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitParent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitParent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CadenaContext extends FactorContext {
		public TerminalNode STRING() { return getToken(MiniBParser.STRING, 0); }
		public CadenaContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterCadena(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitCadena(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitCadena(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IsnanContext extends FactorContext {
		public IsNanFuncContext isNanFunc() {
			return getRuleContext(IsNanFuncContext.class,0);
		}
		public IsnanContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterIsnan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitIsnan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitIsnan(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConcatContext extends FactorContext {
		public ConcatFuncContext concatFunc() {
			return getRuleContext(ConcatFuncContext.class,0);
		}
		public ConcatContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterConcat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitConcat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitConcat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubStrContext extends FactorContext {
		public SubStringFuncContext subStringFunc() {
			return getRuleContext(SubStringFuncContext.class,0);
		}
		public SubStrContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterSubStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitSubStr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitSubStr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LenContext extends FactorContext {
		public LenFuncContext lenFunc() {
			return getRuleContext(LenFuncContext.class,0);
		}
		public LenContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterLen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitLen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitLen(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayLitContext extends FactorContext {
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public ArrayLitContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterArrayLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitArrayLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitArrayLit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CarContext extends FactorContext {
		public TerminalNode CHAR() { return getToken(MiniBParser.CHAR, 0); }
		public CarContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterCar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitCar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitCar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends FactorContext {
		public BooleanContext boolean_() {
			return getRuleContext(BooleanContext.class,0);
		}
		public BoolContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CopyContext extends FactorContext {
		public CopyFunctContext copyFunct() {
			return getRuleContext(CopyFunctContext.class,0);
		}
		public CopyContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterCopy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitCopy(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitCopy(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CharAtContext extends FactorContext {
		public CharAtFunctContext charAtFunct() {
			return getRuleContext(CharAtFunctContext.class,0);
		}
		public CharAtContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterCharAt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitCharAt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitCharAt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumbContext extends FactorContext {
		public TerminalNode NUMBER() { return getToken(MiniBParser.NUMBER, 0); }
		public NumbContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterNumb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitNumb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitNumb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_factor);
		try {
			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new NumbContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				match(NUMBER);
				}
				break;
			case 2:
				_localctx = new FlotanteContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				match(FLOAT);
				}
				break;
			case 3:
				_localctx = new IdentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(241);
				match(IDENTIFIER);
				}
				break;
			case 4:
				_localctx = new ParentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(242);
				match(LPAREN);
				setState(243);
				expression();
				setState(244);
				match(RPAREN);
				}
				break;
			case 5:
				_localctx = new CadenaContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(246);
				match(STRING);
				}
				break;
			case 6:
				_localctx = new CarContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(247);
				match(CHAR);
				}
				break;
			case 7:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(248);
				boolean_();
				}
				break;
			case 8:
				_localctx = new ValContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(249);
				valFunc();
				}
				break;
			case 9:
				_localctx = new LenContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(250);
				lenFunc();
				}
				break;
			case 10:
				_localctx = new IsnanContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(251);
				isNanFunc();
				}
				break;
			case 11:
				_localctx = new CopyContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(252);
				copyFunct();
				}
				break;
			case 12:
				_localctx = new ConcatContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(253);
				concatFunc();
				}
				break;
			case 13:
				_localctx = new SubStrContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(254);
				subStringFunc();
				}
				break;
			case 14:
				_localctx = new CharAtContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(255);
				charAtFunct();
				}
				break;
			case 15:
				_localctx = new ArrayLitContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(256);
				arrayLiteral();
				}
				break;
			case 16:
				_localctx = new ArrayAccContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(257);
				arrayAccess();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValFuncContext extends ParserRuleContext {
		public TerminalNode VAL() { return getToken(MiniBParser.VAL, 0); }
		public TerminalNode LPAREN() { return getToken(MiniBParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniBParser.RPAREN, 0); }
		public ValFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterValFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitValFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitValFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValFuncContext valFunc() throws RecognitionException {
		ValFuncContext _localctx = new ValFuncContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_valFunc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(VAL);
			setState(261);
			match(LPAREN);
			setState(262);
			expression();
			setState(263);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LenFuncContext extends ParserRuleContext {
		public TerminalNode LEN() { return getToken(MiniBParser.LEN, 0); }
		public TerminalNode LPAREN() { return getToken(MiniBParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniBParser.RPAREN, 0); }
		public LenFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lenFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterLenFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitLenFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitLenFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LenFuncContext lenFunc() throws RecognitionException {
		LenFuncContext _localctx = new LenFuncContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_lenFunc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(LEN);
			setState(266);
			match(LPAREN);
			setState(267);
			expression();
			setState(268);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IsNanFuncContext extends ParserRuleContext {
		public TerminalNode ISNAN() { return getToken(MiniBParser.ISNAN, 0); }
		public TerminalNode LPAREN() { return getToken(MiniBParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniBParser.RPAREN, 0); }
		public IsNanFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isNanFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterIsNanFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitIsNanFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitIsNanFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IsNanFuncContext isNanFunc() throws RecognitionException {
		IsNanFuncContext _localctx = new IsNanFuncContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_isNanFunc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(ISNAN);
			setState(271);
			match(LPAREN);
			setState(272);
			expression();
			setState(273);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CopyFunctContext extends ParserRuleContext {
		public TerminalNode COPY() { return getToken(MiniBParser.COPY, 0); }
		public TerminalNode LPAREN() { return getToken(MiniBParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniBParser.RPAREN, 0); }
		public CopyFunctContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_copyFunct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterCopyFunct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitCopyFunct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitCopyFunct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CopyFunctContext copyFunct() throws RecognitionException {
		CopyFunctContext _localctx = new CopyFunctContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_copyFunct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(COPY);
			setState(276);
			match(LPAREN);
			setState(277);
			expression();
			setState(278);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubStringFuncContext extends ParserRuleContext {
		public TerminalNode SUBSTRING() { return getToken(MiniBParser.SUBSTRING, 0); }
		public TerminalNode LPAREN() { return getToken(MiniBParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniBParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniBParser.COMMA, i);
		}
		public TerminalNode RPAREN() { return getToken(MiniBParser.RPAREN, 0); }
		public SubStringFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subStringFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterSubStringFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitSubStringFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitSubStringFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubStringFuncContext subStringFunc() throws RecognitionException {
		SubStringFuncContext _localctx = new SubStringFuncContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_subStringFunc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(SUBSTRING);
			setState(281);
			match(LPAREN);
			setState(282);
			expression();
			setState(283);
			match(COMMA);
			setState(284);
			expression();
			setState(285);
			match(COMMA);
			setState(286);
			expression();
			setState(287);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConcatFuncContext extends ParserRuleContext {
		public TerminalNode CONCAT() { return getToken(MiniBParser.CONCAT, 0); }
		public TerminalNode LPAREN() { return getToken(MiniBParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(MiniBParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MiniBParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniBParser.COMMA, i);
		}
		public ConcatFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concatFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterConcatFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitConcatFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitConcatFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConcatFuncContext concatFunc() throws RecognitionException {
		ConcatFuncContext _localctx = new ConcatFuncContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_concatFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(CONCAT);
			setState(290);
			match(LPAREN);
			setState(291);
			expression();
			setState(294); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(292);
				match(COMMA);
				setState(293);
				expression();
				}
				}
				setState(296); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA );
			setState(298);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CharAtFunctContext extends ParserRuleContext {
		public TerminalNode CHARAT() { return getToken(MiniBParser.CHARAT, 0); }
		public TerminalNode LPAREN() { return getToken(MiniBParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(MiniBParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(MiniBParser.RPAREN, 0); }
		public CharAtFunctContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_charAtFunct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterCharAtFunct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitCharAtFunct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitCharAtFunct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CharAtFunctContext charAtFunct() throws RecognitionException {
		CharAtFunctContext _localctx = new CharAtFunctContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_charAtFunct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(CHARAT);
			setState(301);
			match(LPAREN);
			setState(302);
			expression();
			setState(303);
			match(COMMA);
			setState(304);
			expression();
			setState(305);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayLiteralContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(MiniBParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(MiniBParser.RBRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniBParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniBParser.COMMA, i);
		}
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterArrayLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitArrayLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_arrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			match(LBRACKET);
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 143000283318583296L) != 0)) {
				{
				setState(308);
				expression();
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(309);
					match(COMMA);
					setState(310);
					expression();
					}
					}
					setState(315);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(318);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAccessContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MiniBParser.IDENTIFIER, 0); }
		public TerminalNode LBRACKET() { return getToken(MiniBParser.LBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(MiniBParser.RBRACKET, 0); }
		public ArrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterArrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitArrayAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAccessContext arrayAccess() throws RecognitionException {
		ArrayAccessContext _localctx = new ArrayAccessContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_arrayAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(IDENTIFIER);
			setState(321);
			match(LBRACKET);
			setState(322);
			expression();
			setState(323);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(MiniBParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(MiniBParser.FALSE, 0); }
		public BooleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanContext boolean_() throws RecognitionException {
		BooleanContext _localctx = new BooleanContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_boolean);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorOperationsContext extends ParserRuleContext {
		public FactorOperationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factorOperations; }
	 
		public FactorOperationsContext() { }
		public void copyFrom(FactorOperationsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivContext extends FactorOperationsContext {
		public TerminalNode DIV() { return getToken(MiniBParser.DIV, 0); }
		public DivContext(FactorOperationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultContext extends FactorOperationsContext {
		public TerminalNode MULT() { return getToken(MiniBParser.MULT, 0); }
		public MultContext(FactorOperationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitMult(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ModContext extends FactorOperationsContext {
		public TerminalNode MOD() { return getToken(MiniBParser.MOD, 0); }
		public ModContext(FactorOperationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitMod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorOperationsContext factorOperations() throws RecognitionException {
		FactorOperationsContext _localctx = new FactorOperationsContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_factorOperations);
		try {
			setState(330);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MULT:
				_localctx = new MultContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				match(MULT);
				}
				break;
			case DIV:
				_localctx = new DivContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(328);
				match(DIV);
				}
				break;
			case MOD:
				_localctx = new ModContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(329);
				match(MOD);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpOperationsContext extends ParserRuleContext {
		public ExpOperationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expOperations; }
	 
		public ExpOperationsContext() { }
		public void copyFrom(ExpOperationsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MinusContext extends ExpOperationsContext {
		public TerminalNode MINUS() { return getToken(MiniBParser.MINUS, 0); }
		public MinusContext(ExpOperationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlusContext extends ExpOperationsContext {
		public TerminalNode PLUS() { return getToken(MiniBParser.PLUS, 0); }
		public PlusContext(ExpOperationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniBParserVisitor ) return ((MiniBParserVisitor<? extends T>)visitor).visitPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpOperationsContext expOperations() throws RecognitionException {
		ExpOperationsContext _localctx = new ExpOperationsContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_expOperations);
		try {
			setState(334);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				_localctx = new PlusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(332);
				match(PLUS);
				}
				break;
			case MINUS:
				_localctx = new MinusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(333);
				match(MINUS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001:\u0151\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0001\u0000\u0004"+
		"\u0000F\b\u0000\u000b\u0000\f\u0000G\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001V\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003g\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0003\u0007x\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0004\b\u0080\b\b\u000b\b\f\b\u0081\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u008e\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u0096\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00a3\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0003\f\u00ad\b\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u00b5\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u00bc\b\u000e\n\u000e\f\u000e\u00bf\t\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0005\u000f\u00c4\b\u000f\n\u000f\f\u000f\u00c7\t\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0004\u0011\u00cc\b\u0011\u000b\u0011"+
		"\f\u0011\u00cd\u0001\u0011\u0001\u0011\u0003\u0011\u00d2\b\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00d7\b\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u00dc\b\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0005\u0013\u00e2\b\u0013\n\u0013\f\u0013\u00e5\t\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u00eb\b\u0014"+
		"\n\u0014\f\u0014\u00ee\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0103\b\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0004\u001b\u0127\b\u001b\u000b"+
		"\u001b\f\u001b\u0128\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u0138\b\u001d\n\u001d\f\u001d"+
		"\u013b\t\u001d\u0003\u001d\u013d\b\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001"+
		"\u001f\u0001 \u0001 \u0001 \u0003 \u014b\b \u0001!\u0001!\u0003!\u014f"+
		"\b!\u0001!\u0000\u0000\"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@B\u0000\u0003\u0001"+
		"\u0000/1\u0001\u0000#(\u0001\u000023\u0160\u0000E\u0001\u0000\u0000\u0000"+
		"\u0002U\u0001\u0000\u0000\u0000\u0004W\u0001\u0000\u0000\u0000\u0006`"+
		"\u0001\u0000\u0000\u0000\bj\u0001\u0000\u0000\u0000\no\u0001\u0000\u0000"+
		"\u0000\fr\u0001\u0000\u0000\u0000\u000ew\u0001\u0000\u0000\u0000\u0010"+
		"}\u0001\u0000\u0000\u0000\u0012\u0086\u0001\u0000\u0000\u0000\u0014\u0091"+
		"\u0001\u0000\u0000\u0000\u0016\u009e\u0001\u0000\u0000\u0000\u0018\u00a9"+
		"\u0001\u0000\u0000\u0000\u001a\u00b0\u0001\u0000\u0000\u0000\u001c\u00b8"+
		"\u0001\u0000\u0000\u0000\u001e\u00c0\u0001\u0000\u0000\u0000 \u00c8\u0001"+
		"\u0000\u0000\u0000\"\u00d1\u0001\u0000\u0000\u0000$\u00d3\u0001\u0000"+
		"\u0000\u0000&\u00dd\u0001\u0000\u0000\u0000(\u00e6\u0001\u0000\u0000\u0000"+
		"*\u0102\u0001\u0000\u0000\u0000,\u0104\u0001\u0000\u0000\u0000.\u0109"+
		"\u0001\u0000\u0000\u00000\u010e\u0001\u0000\u0000\u00002\u0113\u0001\u0000"+
		"\u0000\u00004\u0118\u0001\u0000\u0000\u00006\u0121\u0001\u0000\u0000\u0000"+
		"8\u012c\u0001\u0000\u0000\u0000:\u0133\u0001\u0000\u0000\u0000<\u0140"+
		"\u0001\u0000\u0000\u0000>\u0145\u0001\u0000\u0000\u0000@\u014a\u0001\u0000"+
		"\u0000\u0000B\u014e\u0001\u0000\u0000\u0000DF\u0003\u0002\u0001\u0000"+
		"ED\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000"+
		"\u0000GH\u0001\u0000\u0000\u0000H\u0001\u0001\u0000\u0000\u0000IV\u0003"+
		"\u0004\u0002\u0000JV\u0003\u0006\u0003\u0000KV\u0003\b\u0004\u0000LV\u0003"+
		"\n\u0005\u0000MV\u0003\f\u0006\u0000NV\u0003\u000e\u0007\u0000OV\u0003"+
		"\u0010\b\u0000PV\u0003\u0012\t\u0000QV\u0003\u0014\n\u0000RV\u0003\u0016"+
		"\u000b\u0000SV\u0003\u0018\f\u0000TV\u0003\u001a\r\u0000UI\u0001\u0000"+
		"\u0000\u0000UJ\u0001\u0000\u0000\u0000UK\u0001\u0000\u0000\u0000UL\u0001"+
		"\u0000\u0000\u0000UM\u0001\u0000\u0000\u0000UN\u0001\u0000\u0000\u0000"+
		"UO\u0001\u0000\u0000\u0000UP\u0001\u0000\u0000\u0000UQ\u0001\u0000\u0000"+
		"\u0000UR\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UT\u0001\u0000"+
		"\u0000\u0000V\u0003\u0001\u0000\u0000\u0000WX\u0005\u0001\u0000\u0000"+
		"XY\u00054\u0000\u0000YZ\u0005\u001e\u0000\u0000Z[\u0003&\u0013\u0000["+
		"\\\u0005\u0002\u0000\u0000\\]\u0003&\u0013\u0000]^\u0003\"\u0011\u0000"+
		"^_\u0005\u0003\u0000\u0000_\u0005\u0001\u0000\u0000\u0000`a\u0005\u0004"+
		"\u0000\u0000ab\u0003$\u0012\u0000bc\u0005\u0005\u0000\u0000cf\u0003\""+
		"\u0011\u0000de\u0005\u0006\u0000\u0000eg\u0003\"\u0011\u0000fd\u0001\u0000"+
		"\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hi\u0005"+
		"\t\u0000\u0000i\u0007\u0001\u0000\u0000\u0000jk\u0005\u0007\u0000\u0000"+
		"kl\u0003$\u0012\u0000lm\u0003\"\u0011\u0000mn\u0005\t\u0000\u0000n\t\u0001"+
		"\u0000\u0000\u0000op\u0005\n\u0000\u0000pq\u0003&\u0013\u0000q\u000b\u0001"+
		"\u0000\u0000\u0000rs\u0005\u000b\u0000\u0000st\u00056\u0000\u0000tu\u0005"+
		"4\u0000\u0000u\r\u0001\u0000\u0000\u0000vx\u0005\f\u0000\u0000wv\u0001"+
		"\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000"+
		"yz\u00054\u0000\u0000z{\u0005\u001e\u0000\u0000{|\u0003&\u0013\u0000|"+
		"\u000f\u0001\u0000\u0000\u0000}\u007f\u0005\u0010\u0000\u0000~\u0080\u0003"+
		"\u0002\u0001\u0000\u007f~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000"+
		"\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000"+
		"\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0084\u0005\u0011"+
		"\u0000\u0000\u0084\u0085\u0003$\u0012\u0000\u0085\u0011\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0005\u0019\u0000\u0000\u0087\u0088\u0005)\u0000\u0000"+
		"\u0088\u0089\u00054\u0000\u0000\u0089\u008a\u0005-\u0000\u0000\u008a\u008d"+
		"\u0003&\u0013\u0000\u008b\u008c\u0005-\u0000\u0000\u008c\u008e\u0003&"+
		"\u0013\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000"+
		"\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0090\u0005*\u0000"+
		"\u0000\u0090\u0013\u0001\u0000\u0000\u0000\u0091\u0092\u0005\u001a\u0000"+
		"\u0000\u0092\u0093\u00054\u0000\u0000\u0093\u0095\u0005)\u0000\u0000\u0094"+
		"\u0096\u0003\u001c\u000e\u0000\u0095\u0094\u0001\u0000\u0000\u0000\u0095"+
		"\u0096\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097"+
		"\u0098\u0005*\u0000\u0000\u0098\u0099\u0003\"\u0011\u0000\u0099\u009a"+
		"\u0005\u001b\u0000\u0000\u009a\u009b\u0003&\u0013\u0000\u009b\u009c\u0005"+
		"\t\u0000\u0000\u009c\u009d\u0005\u001a\u0000\u0000\u009d\u0015\u0001\u0000"+
		"\u0000\u0000\u009e\u009f\u0005\u001c\u0000\u0000\u009f\u00a0\u00054\u0000"+
		"\u0000\u00a0\u00a2\u0005)\u0000\u0000\u00a1\u00a3\u0003\u001c\u000e\u0000"+
		"\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005*\u0000\u0000\u00a5"+
		"\u00a6\u0003\"\u0011\u0000\u00a6\u00a7\u0005\t\u0000\u0000\u00a7\u00a8"+
		"\u0005\u001c\u0000\u0000\u00a8\u0017\u0001\u0000\u0000\u0000\u00a9\u00aa"+
		"\u00054\u0000\u0000\u00aa\u00ac\u0005)\u0000\u0000\u00ab\u00ad\u0003\u001e"+
		"\u000f\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00af\u0005*\u0000"+
		"\u0000\u00af\u0019\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\u001d\u0000"+
		"\u0000\u00b1\u00b2\u00054\u0000\u0000\u00b2\u00b4\u0005)\u0000\u0000\u00b3"+
		"\u00b5\u0003\u001e\u000f\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b7\u0005*\u0000\u0000\u00b7\u001b\u0001\u0000\u0000\u0000\u00b8\u00bd"+
		"\u00054\u0000\u0000\u00b9\u00ba\u0005-\u0000\u0000\u00ba\u00bc\u00054"+
		"\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\u00bf\u0001\u0000"+
		"\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000"+
		"\u0000\u0000\u00be\u001d\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c5\u0003&\u0013\u0000\u00c1\u00c2\u0005-\u0000\u0000"+
		"\u00c2\u00c4\u0003&\u0013\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c6\u001f\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c8\u00c9\u0007\u0000\u0000\u0000\u00c9"+
		"!\u0001\u0000\u0000\u0000\u00ca\u00cc\u0003\u0002\u0001\u0000\u00cb\u00ca"+
		"\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00cb"+
		"\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00d2"+
		"\u0001\u0000\u0000\u0000\u00cf\u00d2\u0005\u000e\u0000\u0000\u00d0\u00d2"+
		"\u0005\u000f\u0000\u0000\u00d1\u00cb\u0001\u0000\u0000\u0000\u00d1\u00cf"+
		"\u0001\u0000\u0000\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d2#\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d6\u0003&\u0013\u0000\u00d4\u00d5\u0007\u0001"+
		"\u0000\u0000\u00d5\u00d7\u0003&\u0013\u0000\u00d6\u00d4\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00db\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d9\u0003 \u0010\u0000\u00d9\u00da\u0003$\u0012\u0000\u00da"+
		"\u00dc\u0001\u0000\u0000\u0000\u00db\u00d8\u0001\u0000\u0000\u0000\u00db"+
		"\u00dc\u0001\u0000\u0000\u0000\u00dc%\u0001\u0000\u0000\u0000\u00dd\u00e3"+
		"\u0003(\u0014\u0000\u00de\u00df\u0003B!\u0000\u00df\u00e0\u0003(\u0014"+
		"\u0000\u00e0\u00e2\u0001\u0000\u0000\u0000\u00e1\u00de\u0001\u0000\u0000"+
		"\u0000\u00e2\u00e5\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000"+
		"\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\'\u0001\u0000\u0000\u0000"+
		"\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e6\u00ec\u0003*\u0015\u0000\u00e7"+
		"\u00e8\u0003@ \u0000\u00e8\u00e9\u0003*\u0015\u0000\u00e9\u00eb\u0001"+
		"\u0000\u0000\u0000\u00ea\u00e7\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001"+
		"\u0000\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001"+
		"\u0000\u0000\u0000\u00ed)\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ef\u0103\u00055\u0000\u0000\u00f0\u0103\u00058\u0000\u0000"+
		"\u00f1\u0103\u00054\u0000\u0000\u00f2\u00f3\u0005)\u0000\u0000\u00f3\u00f4"+
		"\u0003&\u0013\u0000\u00f4\u00f5\u0005*\u0000\u0000\u00f5\u0103\u0001\u0000"+
		"\u0000\u0000\u00f6\u0103\u00056\u0000\u0000\u00f7\u0103\u00057\u0000\u0000"+
		"\u00f8\u0103\u0003>\u001f\u0000\u00f9\u0103\u0003,\u0016\u0000\u00fa\u0103"+
		"\u0003.\u0017\u0000\u00fb\u0103\u00030\u0018\u0000\u00fc\u0103\u00032"+
		"\u0019\u0000\u00fd\u0103\u00036\u001b\u0000\u00fe\u0103\u00034\u001a\u0000"+
		"\u00ff\u0103\u00038\u001c\u0000\u0100\u0103\u0003:\u001d\u0000\u0101\u0103"+
		"\u0003<\u001e\u0000\u0102\u00ef\u0001\u0000\u0000\u0000\u0102\u00f0\u0001"+
		"\u0000\u0000\u0000\u0102\u00f1\u0001\u0000\u0000\u0000\u0102\u00f2\u0001"+
		"\u0000\u0000\u0000\u0102\u00f6\u0001\u0000\u0000\u0000\u0102\u00f7\u0001"+
		"\u0000\u0000\u0000\u0102\u00f8\u0001\u0000\u0000\u0000\u0102\u00f9\u0001"+
		"\u0000\u0000\u0000\u0102\u00fa\u0001\u0000\u0000\u0000\u0102\u00fb\u0001"+
		"\u0000\u0000\u0000\u0102\u00fc\u0001\u0000\u0000\u0000\u0102\u00fd\u0001"+
		"\u0000\u0000\u0000\u0102\u00fe\u0001\u0000\u0000\u0000\u0102\u00ff\u0001"+
		"\u0000\u0000\u0000\u0102\u0100\u0001\u0000\u0000\u0000\u0102\u0101\u0001"+
		"\u0000\u0000\u0000\u0103+\u0001\u0000\u0000\u0000\u0104\u0105\u0005\u0012"+
		"\u0000\u0000\u0105\u0106\u0005)\u0000\u0000\u0106\u0107\u0003&\u0013\u0000"+
		"\u0107\u0108\u0005*\u0000\u0000\u0108-\u0001\u0000\u0000\u0000\u0109\u010a"+
		"\u0005\u0013\u0000\u0000\u010a\u010b\u0005)\u0000\u0000\u010b\u010c\u0003"+
		"&\u0013\u0000\u010c\u010d\u0005*\u0000\u0000\u010d/\u0001\u0000\u0000"+
		"\u0000\u010e\u010f\u0005\u0014\u0000\u0000\u010f\u0110\u0005)\u0000\u0000"+
		"\u0110\u0111\u0003&\u0013\u0000\u0111\u0112\u0005*\u0000\u0000\u01121"+
		"\u0001\u0000\u0000\u0000\u0113\u0114\u0005\u0015\u0000\u0000\u0114\u0115"+
		"\u0005)\u0000\u0000\u0115\u0116\u0003&\u0013\u0000\u0116\u0117\u0005*"+
		"\u0000\u0000\u01173\u0001\u0000\u0000\u0000\u0118\u0119\u0005\u0017\u0000"+
		"\u0000\u0119\u011a\u0005)\u0000\u0000\u011a\u011b\u0003&\u0013\u0000\u011b"+
		"\u011c\u0005-\u0000\u0000\u011c\u011d\u0003&\u0013\u0000\u011d\u011e\u0005"+
		"-\u0000\u0000\u011e\u011f\u0003&\u0013\u0000\u011f\u0120\u0005*\u0000"+
		"\u0000\u01205\u0001\u0000\u0000\u0000\u0121\u0122\u0005\u0016\u0000\u0000"+
		"\u0122\u0123\u0005)\u0000\u0000\u0123\u0126\u0003&\u0013\u0000\u0124\u0125"+
		"\u0005-\u0000\u0000\u0125\u0127\u0003&\u0013\u0000\u0126\u0124\u0001\u0000"+
		"\u0000\u0000\u0127\u0128\u0001\u0000\u0000\u0000\u0128\u0126\u0001\u0000"+
		"\u0000\u0000\u0128\u0129\u0001\u0000\u0000\u0000\u0129\u012a\u0001\u0000"+
		"\u0000\u0000\u012a\u012b\u0005*\u0000\u0000\u012b7\u0001\u0000\u0000\u0000"+
		"\u012c\u012d\u0005\u0018\u0000\u0000\u012d\u012e\u0005)\u0000\u0000\u012e"+
		"\u012f\u0003&\u0013\u0000\u012f\u0130\u0005-\u0000\u0000\u0130\u0131\u0003"+
		"&\u0013\u0000\u0131\u0132\u0005*\u0000\u0000\u01329\u0001\u0000\u0000"+
		"\u0000\u0133\u013c\u0005+\u0000\u0000\u0134\u0139\u0003&\u0013\u0000\u0135"+
		"\u0136\u0005-\u0000\u0000\u0136\u0138\u0003&\u0013\u0000\u0137\u0135\u0001"+
		"\u0000\u0000\u0000\u0138\u013b\u0001\u0000\u0000\u0000\u0139\u0137\u0001"+
		"\u0000\u0000\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u013d\u0001"+
		"\u0000\u0000\u0000\u013b\u0139\u0001\u0000\u0000\u0000\u013c\u0134\u0001"+
		"\u0000\u0000\u0000\u013c\u013d\u0001\u0000\u0000\u0000\u013d\u013e\u0001"+
		"\u0000\u0000\u0000\u013e\u013f\u0005,\u0000\u0000\u013f;\u0001\u0000\u0000"+
		"\u0000\u0140\u0141\u00054\u0000\u0000\u0141\u0142\u0005+\u0000\u0000\u0142"+
		"\u0143\u0003&\u0013\u0000\u0143\u0144\u0005,\u0000\u0000\u0144=\u0001"+
		"\u0000\u0000\u0000\u0145\u0146\u0007\u0002\u0000\u0000\u0146?\u0001\u0000"+
		"\u0000\u0000\u0147\u014b\u0005!\u0000\u0000\u0148\u014b\u0005\"\u0000"+
		"\u0000\u0149\u014b\u0005\r\u0000\u0000\u014a\u0147\u0001\u0000\u0000\u0000"+
		"\u014a\u0148\u0001\u0000\u0000\u0000\u014a\u0149\u0001\u0000\u0000\u0000"+
		"\u014bA\u0001\u0000\u0000\u0000\u014c\u014f\u0005\u001f\u0000\u0000\u014d"+
		"\u014f\u0005 \u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000\u014e\u014d"+
		"\u0001\u0000\u0000\u0000\u014fC\u0001\u0000\u0000\u0000\u0018GUfw\u0081"+
		"\u008d\u0095\u00a2\u00ac\u00b4\u00bd\u00c5\u00cd\u00d1\u00d6\u00db\u00e3"+
		"\u00ec\u0102\u0128\u0139\u013c\u014a\u014e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}