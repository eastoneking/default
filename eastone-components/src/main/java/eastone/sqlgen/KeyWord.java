/*
 * create:2014年10月12日 下午8:15:38
 * author:wangds  
 */
package eastone.sqlgen;

import eastone.common.GeneralParentObject;

/**
 * .
 * @author wangds
 *
 */
public final class KeyWord extends GeneralParentObject implements SqlExpression {
    
    public static final KeyWord SELECT = new KeyWord("select");
    public static final KeyWord INSERT_INTO = new KeyWord("insert into");
    public static final KeyWord UPDATE = new KeyWord("update");
    public static final KeyWord DELETE = new KeyWord("delete");
    public static final KeyWord FROM = new KeyWord("from");
    public static final KeyWord WHERE = new KeyWord("where");
    public static final KeyWord GROUP_BY = new KeyWord("group by");
    public static final KeyWord HAVING = new KeyWord("having");
    public static final KeyWord ORDER_BY = new KeyWord("order by");
    public static final KeyWord JOIN = new KeyWord("join");
    public static final KeyWord LEFT_JOIN = new KeyWord("left join");
    public static final KeyWord RIGHT_JOIN = new KeyWord("right join");
    public static final KeyWord UNION = new KeyWord("union");
    public static final KeyWord UNION_ALL = new KeyWord("union all");
    public static final KeyWord MINUS = new KeyWord("minus");
    public static final KeyWord ON = new KeyWord("on");
    public static final KeyWord AS = new KeyWord("as");
    public static final KeyWord BLANKSPACE = new KeyWord(" ");
    public static final KeyWord RETURN = new KeyWord("\n");
    public static final KeyWord EQ = new KeyWord("=");
    public static final KeyWord NOT_EQ = new KeyWord("!=");
    public static final KeyWord LT = new KeyWord("<");
    public static final KeyWord GT = new KeyWord(">");
    public static final KeyWord LT_OR_EQ = new KeyWord("<=");
    public static final KeyWord GT_OR_EQ = new KeyWord(">=");
    public static final KeyWord NOT = new KeyWord("not");
    public static final KeyWord LOGIC_NOT = new KeyWord("!");
    public static final KeyWord LOGIC_AND = new KeyWord("and");
    public static final KeyWord LOGIC_OR = new KeyWord("or");
    public static final KeyWord BRACKET_BEGIN = new KeyWord("(");
    public static final KeyWord BRACKET_END = new KeyWord(")");
    public static final KeyWord MATH_PULS = new KeyWord("+");
    public static final KeyWord MATH_MINUS = new KeyWord("-");
    public static final KeyWord MATH_MULTIPICATION = new KeyWord("*");
    public static final KeyWord MATH_DIVISION = new KeyWord("/");
    public static final KeyWord STRING_CONCAT = new KeyWord("||");
    public static final KeyWord QUOTATION = new KeyWord("'");
    public static final KeyWord DOUBLE_QUATATION = new KeyWord("\"");
    public static final KeyWord WITH = new KeyWord("with");
    /**
     * .
     */
    private String text;
    /**
     * The constructor of KeyWord.
     * @author wangds 2014年10月12日 下午8:18:46.
     * @param text
     */
    public KeyWord(String text){
        
    }
    /**
     * The setter method of the property text.
     * @param thetext the text to set
     * @author wangds 2014年10月12日 下午8:19:06.
     */
    public void setText(String text) {
        this.text = text;
    }
    /**
     * The getter method of the property text.
     * @author wangds 2014年10月12日 下午8:19:11.
     * @return the text.
     */
    public String getText() {
        return text;
    }
    /*
     * @see eastone.sqlgen.Expression#toText()
     * @author wangds 2014年10月12日 下午8:15:38.
     */
    @Override
    public String toText() {
        return this.text;
    }
    
    /*
     * @see java.lang.Object#toString()
     * @author wangds 2014年10月12日 下午8:20:37.
     */
    @Override
    public String toString() {
        return this.toText();
    }

}
