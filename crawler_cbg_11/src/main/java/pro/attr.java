package pro;

public class attr {
    private String desc=null;   //道具中类
    private long iType=0;
    private String cGblKey=null;
    private int iAmount=1;   //道具的数量
    private int iMLast;
    private String cSkill;
    private int iScore; //装备评分
    private String cAdd;
    private int iLast;
    private int iLevel;     //黄宝石有这个属性   { "desc":"","iType":108033,"iLevel":3,"cGblKey":"5lI0002mLim","iAmount":9}
    private String iBan;//cE89A4D评价 1000","cSkill":"1|0|0|0|0","cGblKey":"5uI0000nXmy","iType":110450,"iLast":1000,"cAdd":"A30","iBan":8,"iScore":1000,"iLimit":4,"iLife":1,"iLevel":10000,"iKind":1}
    private String iLimit;
    private String iKind;
    private String iClimit;
    private String iMlimit;
    private String iSlimit;
    private String iMp;

    public String getiRep() {
        return iRep;
    }

    public void setiRep(String iRep) {
        this.iRep = iRep;
    }

    private String iRep;

    public String getiMp() {
        return iMp;
    }

    public void setiMp(String iMp) {
        this.iMp = iMp;
    }

    public String getiHp() {
        return iHp;
    }

    public void setiHp(String iHp) {
        this.iHp = iHp;
    }

    private String iHp;

    public String getiClimit() {
        return iClimit;
    }

    public void setiClimit(String iClimit) {
        this.iClimit = iClimit;
    }

    public String getiMlimit() {
        return iMlimit;
    }

    public void setiMlimit(String iMlimit) {
        this.iMlimit = iMlimit;
    }

    public String getiSlimit() {
        return iSlimit;
    }

    public void setiSlimit(String iSlimit) {
        this.iSlimit = iSlimit;
    }

    public String getcMake() {
        return cMake;
    }

    public void setcMake(String cMake) {
        this.cMake = cMake;
    }

    private String cMake;

    public String getiLife() {
        return iLife;
    }

    public void setiLife(String iLife) {
        this.iLife = iLife;
    }

    private String iLife;


    public String getiKind() {
        return iKind;
    }

    public void setiKind(String iKind) {
        this.iKind = iKind;
    }

    public String getiLimit() {
        return iLimit;
    }

    public void setiLimit(String iLimit) {
        this.iLimit = iLimit;
    }

    public String getiBan() {
        return iBan;
    }

    public void setiBan(String iBan) {
        this.iBan = iBan;
    }

    public int getiLevel() {
        return iLevel;
    }

    public void setiLevel(int iLevel) {
        this.iLevel = iLevel;
    }

    public String getcSkill() {
        return cSkill;
    }

    public void setcSkill(String cSkill) {
        this.cSkill = cSkill;
    }

    public int getiScore() {
        return iScore;
    }

    public void setiScore(int iScore) {
        this.iScore = iScore;
    }

    public String getcAdd() {
        return cAdd;
    }

    public void setcAdd(String cAdd) {
        this.cAdd = cAdd;
    }

    public int getiLast() {
        return iLast;
    }

    public void setiLast(int iLast) {
        this.iLast = iLast;
    }

    public int getiBas() {
        return iBas;
    }

    public void setiBas(int iBas) {
        this.iBas = iBas;
    }

    private int iBas;   //装备最大强化值

/*{ "desc":"#cF8FCF8【炼化价值】520#r#cF8FCF8【装备耐久】1000/1000
#r#cE43D31装备后禁交易
#r#cFEFF72增加AP +5.5% [4]
#r#c00FFFF强化值 0/16
#r#c00FFFF#r觉醒技 #r未开启#r未开启#r未开启#r未开启
#r#cE89A4D评价 2150#r"   ,
"cSkill":"0|0|0|0","iType":110706,"cGblKey":"5lI0002JAkt","iScore":2150,"cAdd":"ZA55","iLast":1000,"iBas":16}
    */
    public int getiMLast() {
        return iMLast;
    }

    public void setiMLast(int iMLast) {
        this.iMLast = iMLast;
    }

    @Override
    public String toString() {
        return "attr{" +
                "desc='" + desc + '\'' +
                ", iType=" + iType +
                ", cGb1key='" + cGblKey + '\'' +
                ", iAmount=" + iAmount +
                '}';
    }

    public attr() {
    }

    public attr(String desc, long iType, String cGblKey, int iAmount) {
        this.desc = desc;
        this.iType = iType;
        this.cGblKey = cGblKey;
        this.iAmount = iAmount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getiType() {
        return iType;
    }

    public void setiType(long iType) {
        this.iType = iType;
    }

    public String getcGblKey() {
        return cGblKey;
    }

    public void setcGblKey(String cGblKey) {
        this.cGblKey = cGblKey;
    }

    public int getiAmount() {
        return iAmount;
    }

    public void setiAmount(int iAmount) {
        this.iAmount = iAmount;
    }
}
