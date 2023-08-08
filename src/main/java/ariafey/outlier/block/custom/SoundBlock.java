package ariafey.outlier.block.custom;

import ariafey.outlier.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SoundBlock extends Block {
    public SoundBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(SOUNDNO, 1));
    }

    public static final IntProperty SOUNDNO = IntProperty.of("soundno", 1, 3);

    @Override
    public ActionResult onUse(BlockState blockstate, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {

        if(player.isSneaking()) {
            if(!world.isClient() && hand == Hand.MAIN_HAND) {
                world.setBlockState(pos, blockstate.cycle(SOUNDNO));
                return ActionResult.SUCCESS;
            }

        } else {
            if (blockstate.get(SOUNDNO) == 2) {
                world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BIT.value(), SoundCategory.BLOCKS);
                return ActionResult.CONSUME;
            } else if (blockstate.get(SOUNDNO) == 3) {
                world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_GUITAR.value(), SoundCategory.BLOCKS);
                return ActionResult.CONSUME;
            } else {
                world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BANJO.value(), SoundCategory.BLOCKS);
                return ActionResult.CONSUME;
            }
        }
        return super.onUse(blockstate, world, pos, player, hand, hit);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.outlier-mod.sound_block.expanded"));
        } else {
            tooltip.add(Text.translatable("tooltip.outlier-mod.sound_block.contracted"));
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SOUNDNO);
    }
}
