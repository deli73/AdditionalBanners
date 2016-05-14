package net.darkhax.additionalbanners;

import java.util.List;

import net.darkhax.additionalbanners.lib.BannerUtils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTabAdditionalBanners extends CreativeTabs {
    
    public CreativeTabAdditionalBanners() {
        
        super("additionalbanners");
        this.setBackgroundImageName("item_search.png");
    }
    
    @Override
    public Item getTabIconItem () {
        
        return Items.BANNER;
    }
    
    @Override
    public boolean hasSearchBar () {
        
        return true;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void displayAllRelevantItems (List<ItemStack> itemList) {
        
        super.displayAllRelevantItems(itemList);
        
        for (final EnumDyeColor color : EnumDyeColor.values())
            for (final BannerUtils.TypeDesign design : BannerUtils.TypeDesign.values()) {
                
                final ItemStack stack = BannerUtils.createBanner(color, BannerUtils.createPatternList(color, design.getLayers()));
                stack.setStackDisplayName("Letter: " + design.name().toLowerCase());
                itemList.add(stack);
            }
    }
}