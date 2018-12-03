/*    */ package slimebound.powers;
/*    */
/*    */

/*    */

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.ThornsPower;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import slimebound.SlimeboundMod;

/*    */
/*    */
        /*    */
        /*    */

/*    */
/*    */ public class NextTurnGainStrengthPower extends AbstractPower
/*    */ {
    /*    */   public static final String POWER_ID = "NextTurnGainStrengthPower";
    /*    */   public static final String NAME = "Potency";
    public static PowerType POWER_TYPE = PowerType.BUFF;
    /*    */   public static final String IMG = "powers/DelayedAttackSmall.png";
    public static final Logger logger = LogManager.getLogger(SlimeboundMod.class.getName()); // lets us log output

    /* 14 */   public static String[] DESCRIPTIONS;
    /*    */   private AbstractCreature source;

    /*    */
    /*    */
    /*    */
    public NextTurnGainStrengthPower(AbstractCreature owner, AbstractCreature source, int amount)
    /*    */ {
        /* 23 */
        this.name = NAME;
        /* 24 */
        this.ID = POWER_ID;

        /* 25 */
        this.owner = owner;
        /* 26 */
        this.source = source;
        /*    */
        /* 28 */
        this.img = new com.badlogic.gdx.graphics.Texture(SlimeboundMod.getResourcePath(IMG));
        /* 29 */
        this.type = POWER_TYPE;
        /* 30 */
        this.amount = amount;
        this.DESCRIPTIONS = CardCrawlGame.languagePack.getPowerStrings(this.ID).DESCRIPTIONS;
        /*  84 */
        this.name = CardCrawlGame.languagePack.getPowerStrings(this.ID).NAME;
        /* 31 */
        updateDescription();
        /*    */
    }

    /*    */
    /*    */
    public void updateDescription()
    /*    */ {
        /* 36 */
        /* 37 */
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
        /*    */
        /*    */
    }


    public void atStartOfTurn()
        /*    */ {
        /* 33 */
        flash();
        /* 34 */
        AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.ApplyPowerAction(this.owner, this.owner, new StrengthPower(this.owner, this.amount), this.amount));
        /*    */
        /* 36 */
        AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction(this.owner, this.owner, "NextTurnGainStrengthPower"));


    }
    /*    */

}
/*    */


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\SlayTheSpire\mods\SlimeboundMod.jar!\slimboundmod\powers\SearingPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */