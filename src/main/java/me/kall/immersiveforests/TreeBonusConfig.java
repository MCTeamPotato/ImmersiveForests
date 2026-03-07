package me.kall.immersiveforests;

import me.kall.duplicationless.config.JsonConfig;

public class TreeBonusConfig {
    private static final JsonConfig CONFIG = JsonConfig.create(ImmersiveForests.MOD_ID, "1")
            .put("TrunkBonus", 2.0)
            .put("FoliageHorizontalBonus", 1.5)
            .put("FoliageVerticalBonus", 1.5)
            .put("FoliageDecayRangeBonus", 1.5)
            .put("LeavesNoLongerBlockLight", false)
            .initialize();

    public static final double FOLIAGE_Y_BONUS = CONFIG.getDouble("FoliageVerticalBonus");
    public static final double FOLIAGE_XZ_BONUS = CONFIG.getDouble("FoliageHorizontalBonus");
    public static final double TRUNK_BONUS = CONFIG.getDouble("TrunkBonus");
    public static final double FOLIAGE_DECAY_RANGE_BONUS = CONFIG.getDouble("FoliageDecayRangeBonus");
    public static final boolean TRANSPARENT_LEAVES = CONFIG.getBoolean("LeavesNoLongerBlockLight");
}
