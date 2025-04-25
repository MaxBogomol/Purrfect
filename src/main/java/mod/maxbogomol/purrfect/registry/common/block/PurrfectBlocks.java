package mod.maxbogomol.purrfect.registry.common.block;

import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.common.block.blahaj.BlahajBlock;
import mod.maxbogomol.purrfect.common.block.flag.FlagBlock;
import mod.maxbogomol.purrfect.common.block.flag.FlagWallBlock;
import mod.maxbogomol.purrfect.common.block.flag.FlagpoleBlock;
import mod.maxbogomol.purrfect.common.block.pharmacist_table.PharmacistTableBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PurrfectBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Purrfect.MOD_ID);

    public static final RegistryObject<Block> PHARMACIST_TABLE = BLOCKS.register("pharmacist_table", () -> new PharmacistTableBlock(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE)));

    public static final RegistryObject<Block> BLAHAJ_PLUSH = BLOCKS.register("blahaj_plush", () -> new BlahajBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).noOcclusion()));
    public static final RegistryObject<Block> PINK_BLAHAJ_PLUSH = BLOCKS.register("pink_blahaj_plush", () -> new BlahajBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(MapColor.TERRACOTTA_PINK).noOcclusion()));

    public static final RegistryObject<Block> FLAGPOLE = BLOCKS.register("flagpole", () -> new FlagpoleBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)));

    public static final RegistryObject<Block> WHITE_FLAG = BLOCKS.register("white_flag", () -> new FlagBlock(FlagBlock.WHITE, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> LIGHT_GRAY_FLAG = BLOCKS.register("light_gray_flag", () -> new FlagBlock(FlagBlock.LIGHT_GRAY, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> GRAY_FLAG = BLOCKS.register("gray_flag", () -> new FlagBlock(FlagBlock.GRAY, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> BLACK_FLAG = BLOCKS.register("black_flag", () -> new FlagBlock(FlagBlock.BLACK, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> BROWN_FLAG = BLOCKS.register("brown_flag", () -> new FlagBlock(FlagBlock.BROWN, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> RED_FLAG = BLOCKS.register("red_flag", () -> new FlagBlock(FlagBlock.RED, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> ORANGE_FLAG = BLOCKS.register("orange_flag", () -> new FlagBlock(FlagBlock.ORANGE, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> YELLOW_FLAG = BLOCKS.register("yellow_flag", () -> new FlagBlock(FlagBlock.YELLOW, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> LIME_FLAG = BLOCKS.register("lime_flag", () -> new FlagBlock(FlagBlock.LIME, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> GREEN_FLAG = BLOCKS.register("green_flag", () -> new FlagBlock(FlagBlock.GREEN, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> CYAN_FLAG = BLOCKS.register("cyan_flag", () -> new FlagBlock(FlagBlock.CYAN, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> LIGHT_BLUE_FLAG = BLOCKS.register("light_blue_flag", () -> new FlagBlock(FlagBlock.LIGHT_BLUE, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> BLUE_FLAG = BLOCKS.register("blue_flag", () -> new FlagBlock(FlagBlock.BLUE, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> PURPLE_FLAG = BLOCKS.register("purple_flag", () -> new FlagBlock(FlagBlock.PURPLE, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> MAGENTA_FLAG = BLOCKS.register("magenta_flag", () -> new FlagBlock(FlagBlock.MAGENTA, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> PINK_FLAG = BLOCKS.register("pink_flag", () -> new FlagBlock(FlagBlock.PINK, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> RAINBOW_FLAG = BLOCKS.register("rainbow_flag", () -> new FlagBlock(FlagBlock.RAINBOW, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> HETEROSEXUAL_FLAG = BLOCKS.register("heterosexual_flag", () -> new FlagBlock(FlagBlock.HETEROSEXUAL, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> PRIDE_FLAG = BLOCKS.register("pride_flag", () -> new FlagBlock(FlagBlock.PRIDE, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> LESBIAN_FLAG = BLOCKS.register("lesbian_flag", () -> new FlagBlock(FlagBlock.LESBIAN, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> GAY_FLAG = BLOCKS.register("gay_flag", () -> new FlagBlock(FlagBlock.GAY, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> BI_FLAG = BLOCKS.register("bi_flag", () -> new FlagBlock(FlagBlock.BI, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> TRANS_FLAG = BLOCKS.register("trans_flag", () -> new FlagBlock(FlagBlock.TRANS, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> ENBY_FLAG = BLOCKS.register("enby_flag", () -> new FlagBlock(FlagBlock.ENBY, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> GENDERFLUID_FLAG = BLOCKS.register("genderfluid_flag", () -> new FlagBlock(FlagBlock.GENDERFLUID, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> DEMIBOY_FLAG = BLOCKS.register("demiboy_flag", () -> new FlagBlock(FlagBlock.DEMIBOY, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> DEMIGIRL_FLAG = BLOCKS.register("demigirl_flag", () -> new FlagBlock(FlagBlock.DEMIGIRL, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> DEMIGENDER_FLAG = BLOCKS.register("demigender_flag", () -> new FlagBlock(FlagBlock.DEMIGENDER, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> AGENDER_FLAG = BLOCKS.register("agender_flag", () -> new FlagBlock(FlagBlock.AGENDER, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> PAN_FLAG = BLOCKS.register("pan_flag", () -> new FlagBlock(FlagBlock.PAN, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> OMNI_FLAG = BLOCKS.register("omni_flag", () -> new FlagBlock(FlagBlock.OMNI, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> POLY_FLAG = BLOCKS.register("poly_flag", () -> new FlagBlock(FlagBlock.POLY, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> DEMISEXUAL_FLAG = BLOCKS.register("demisexual_flag", () -> new FlagBlock(FlagBlock.DEMISEXUAL, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> ACE_FLAG = BLOCKS.register("ace_flag", () -> new FlagBlock(FlagBlock.ACE, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> ARO_FLAG = BLOCKS.register("aro_flag", () -> new FlagBlock(FlagBlock.ARO, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> AROACE_FLAG = BLOCKS.register("aroace_flag", () -> new FlagBlock(FlagBlock.AROACE, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> KVASSSEXUAL_FLAG = BLOCKS.register("kvasssexual_flag", () -> new FlagBlock(FlagBlock.KVASSSEXUAL, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> BEERSEXUAL_FLAG = BLOCKS.register("beersexual_flag", () -> new FlagBlock(FlagBlock.BEERSEXUAL, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> WIZARDS_REBORN_FLAG = BLOCKS.register("wizards_reborn_flag", () -> new FlagBlock(FlagBlock.WIZARDS_REBORN, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> FLUFFY_FUR_FLAG = BLOCKS.register("fluffy_fur_flag", () -> new FlagBlock(FlagBlock.FLUFFY_FUR, BlockBehaviour.Properties.copy(FLAGPOLE.get())));

    public static final RegistryObject<Block> WHITE_WALL_FLAG = BLOCKS.register("white_wall_flag", () -> new FlagWallBlock(FlagBlock.WHITE, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> LIGHT_GRAY_WALL_FLAG = BLOCKS.register("light_gray_wall_flag", () -> new FlagWallBlock(FlagBlock.LIGHT_GRAY, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> GRAY_WALL_FLAG = BLOCKS.register("gray_wall_flag", () -> new FlagWallBlock(FlagBlock.GRAY, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> BLACK_WALL_FLAG = BLOCKS.register("black_wall_flag", () -> new FlagWallBlock(FlagBlock.BLACK, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> BROWN_WALL_FLAG = BLOCKS.register("brown_wall_flag", () -> new FlagWallBlock(FlagBlock.BROWN, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> RED_WALL_FLAG = BLOCKS.register("red_wall_flag", () -> new FlagWallBlock(FlagBlock.RED, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> ORANGE_WALL_FLAG = BLOCKS.register("orange_wall_flag", () -> new FlagWallBlock(FlagBlock.ORANGE, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> YELLOW_WALL_FLAG = BLOCKS.register("yellow_wall_flag", () -> new FlagWallBlock(FlagBlock.YELLOW, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> LIME_WALL_FLAG = BLOCKS.register("lime_wall_flag", () -> new FlagWallBlock(FlagBlock.LIME, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> GREEN_WALL_FLAG = BLOCKS.register("green_wall_flag", () -> new FlagWallBlock(FlagBlock.GREEN, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> CYAN_WALL_FLAG = BLOCKS.register("cyan_wall_flag", () -> new FlagWallBlock(FlagBlock.CYAN, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> LIGHT_BLUE_WALL_FLAG = BLOCKS.register("light_blue_wall_flag", () -> new FlagWallBlock(FlagBlock.LIGHT_BLUE, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> BLUE_WALL_FLAG = BLOCKS.register("blue_wall_flag", () -> new FlagWallBlock(FlagBlock.BLUE, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> PURPLE_WALL_FLAG = BLOCKS.register("purple_wall_flag", () -> new FlagWallBlock(FlagBlock.PURPLE, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> MAGENTA_WALL_FLAG = BLOCKS.register("magenta_wall_flag", () -> new FlagWallBlock(FlagBlock.MAGENTA, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> PINK_WALL_FLAG = BLOCKS.register("pink_wall_flag", () -> new FlagWallBlock(FlagBlock.PINK, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> RAINBOW_WALL_FLAG = BLOCKS.register("rainbow_wall_flag", () -> new FlagWallBlock(FlagBlock.RAINBOW, BlockBehaviour.Properties.copy(FLAGPOLE.get())));
    public static final RegistryObject<Block> HETEROSEXUAL_WALL_FLAG = BLOCKS.register("heterosexual_wall_flag", () -> new FlagWallBlock(FlagBlock.HETEROSEXUAL, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> PRIDE_WALL_FLAG = BLOCKS.register("pride_wall_flag", () -> new FlagWallBlock(FlagBlock.PRIDE, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> LESBIAN_WALL_FLAG = BLOCKS.register("lesbian_wall_flag", () -> new FlagWallBlock(FlagBlock.LESBIAN, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> GAY_WALL_FLAG = BLOCKS.register("gay_wall_flag", () -> new FlagWallBlock(FlagBlock.GAY, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> BI_WALL_FLAG = BLOCKS.register("bi_wall_flag", () -> new FlagWallBlock(FlagBlock.BI, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> TRANS_WALL_FLAG = BLOCKS.register("trans_wall_flag", () -> new FlagWallBlock(FlagBlock.TRANS, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> ENBY_WALL_FLAG = BLOCKS.register("enby_wall_flag", () -> new FlagWallBlock(FlagBlock.ENBY, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> GENDERFLUID_WALL_FLAG = BLOCKS.register("genderfluid_wall_flag", () -> new FlagWallBlock(FlagBlock.GENDERFLUID, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> DEMIBOY_WALL_FLAG = BLOCKS.register("demiboy_wall_flag", () -> new FlagWallBlock(FlagBlock.DEMIBOY, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> DEMIGIRL_WALL_FLAG = BLOCKS.register("demigirl_wall_flag", () -> new FlagWallBlock(FlagBlock.DEMIGIRL, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> DEMIGENDER_WALL_FLAG = BLOCKS.register("demigender_wall_flag", () -> new FlagWallBlock(FlagBlock.DEMIGENDER, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> AGENDER_WALL_FLAG = BLOCKS.register("agender_wall_flag", () -> new FlagWallBlock(FlagBlock.AGENDER, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> PAN_WALL_FLAG = BLOCKS.register("pan_wall_flag", () -> new FlagWallBlock(FlagBlock.PAN, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> OMNI_WALL_FLAG = BLOCKS.register("omni_wall_flag", () -> new FlagWallBlock(FlagBlock.OMNI, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> POLY_WALL_FLAG = BLOCKS.register("poly_wall_flag", () -> new FlagWallBlock(FlagBlock.POLY, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> DEMISEXUAL_WALL_FLAG = BLOCKS.register("demisexual_wall_flag", () -> new FlagWallBlock(FlagBlock.DEMISEXUAL, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> ACE_WALL_FLAG = BLOCKS.register("ace_wall_flag", () -> new FlagWallBlock(FlagBlock.ACE, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> ARO_WALL_FLAG = BLOCKS.register("aro_wall_flag", () -> new FlagWallBlock(FlagBlock.ARO, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> AROACE_WALL_FLAG = BLOCKS.register("aroace_wall_flag", () -> new FlagWallBlock(FlagBlock.AROACE, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> KVASSSEXUAL_WALL_FLAG = BLOCKS.register("kvasssexual_wall_flag", () -> new FlagWallBlock(FlagBlock.KVASSSEXUAL, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> BEERSEXUAL_WALL_FLAG = BLOCKS.register("beersexual_wall_flag", () -> new FlagWallBlock(FlagBlock.BEERSEXUAL, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> WIZARDS_REBORN_WALL_FLAG = BLOCKS.register("wizards_reborn_wall_flag", () -> new FlagWallBlock(FlagBlock.WIZARDS_REBORN, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));
    public static final RegistryObject<Block> FLUFFY_FUR_WALL_FLAG = BLOCKS.register("fluffy_fur_wall_flag", () -> new FlagWallBlock(FlagBlock.FLUFFY_FUR, BlockBehaviour.Properties.copy(FLAGPOLE.get()).noCollission()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
