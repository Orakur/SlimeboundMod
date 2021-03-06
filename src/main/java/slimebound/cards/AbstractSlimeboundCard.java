package slimebound.cards;

import basemod.ReflectionHacks;
import basemod.abstracts.CustomCard;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.cardManip.CardFlashVfx;
import slimebound.SlimeboundMod;
import slimebound.vfx.GoopCardFlash;
import sun.reflect.Reflection;


public abstract class AbstractSlimeboundCard extends CustomCard {
    public AbstractSlimeboundCard(String id, String name, String img, int cost, String rawDescription, CardType type, CardColor color,
                               CardRarity rarity, CardTarget target) {
        super(id, name, img, cost, rawDescription, type,
                color, rarity, target);
    }

    public int selfDamage;
    public boolean upgradeSelfDamage;
    public boolean isSelfDamageModified;
    public int poison;
    public boolean upgradePoison;
    public boolean isPoisonModified;

    public int slimed;
    public int baseSlimed;
    public boolean isSlimedModified;
    public boolean upgradeSlimed;

    public boolean goopflashVfx;


    public void upgradeSlimed(int amount) {
        this.baseSlimed += amount;
        this.slimed = this.baseSlimed + SlimeboundMod.getAcidTongueBonus(AbstractDungeon.player);
        if (this.slimed > this.baseSlimed || amount > 0) this.isSlimedModified = true;
    }

    public void upgradeLickSlimed(int amount) {
        this.baseSlimed += amount;
        this.slimed = this.baseSlimed + SlimeboundMod.getGluttonyBonus(AbstractDungeon.player);
        if (this.slimed > this.baseSlimed || amount > 0) this.isSlimedModified = true;
    }



    public void unlock() {
        SlimeboundMod.logger.info("Unlocked.");
        this.isLocked = false;

    }






}