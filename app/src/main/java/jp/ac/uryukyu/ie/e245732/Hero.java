package jp.ac.uryukyu.ie.e245732;

/**
 * ヒーロークラス。
 *  String name; //勇者の名前
 *  int hitPoint; //勇者のHP
 *  int attack; //勇者の攻撃力
 *  boolean dead; //勇者の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
     */
    public Hero (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * Enemyへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param e 攻撃対象
     */
    public void attack(Enemy e){
        if(this.dead == false){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, e.getName(), damage);
            e.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", name);
        }
    }

    /** nameを設定する
     * @param name 設定したい名前
     */
    public void setName(String name){
        this.name = name;
    }
    /** hitPointを設定する
     * @param hitPoint 設定したいHP
     */
    public void setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }
    /** attackを設定する
     * @param attack 設定したい攻撃力
     */
    public void setAttack(int attack){
        this.attack = attack;
    }
    /** deadを設定する
     * @param dead 設定したいdeadの状態
     */
    public void setDead(boolean dead){
        this.dead = dead;
    }

    /** nameを取得する
     * @return 名前
     */
    public String getName(){
        return this.name;
    }
    /** hitPointを取得する
     * @return HP
     */
    public int getHitPoint(){
        return this.hitPoint;
    }
    /** attackを取得する
     * @return 攻撃力
     */
    public int getAttack(){
        return this.attack;
    }
    /** deadを取得する
     * @return dead(true または false)
     */
    public boolean getDead(){
        return this.dead;
    }
}