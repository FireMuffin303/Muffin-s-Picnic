package net.firemuffin303.omorbasket.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.firemuffin303.omorbasket.common.registry.ModItems;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class LangDataGen extends FabricLanguageProvider {
    protected LangDataGen(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
        translationBuilder.add("muffins_picnic.container.basket","Picnic Basket");
        translationBuilder.add(ModItems.WHITE_PICNIC_BASKET.get(),"White Picnic Basket");
        translationBuilder.add(ModItems.LIGHT_GRAY_PICNIC_BASKET.get(),"Light Gray Picnic Basket");
        translationBuilder.add(ModItems.GRAY_PICNIC_BASKET.get(),"Gray Picnic Basket");
        translationBuilder.add(ModItems.BLACK_PICNIC_BASKET.get(),"Black Picnic Basket");
        translationBuilder.add(ModItems.BROWN_PICNIC_BASKET.get(),"Brown Picnic Basket");
        translationBuilder.add(ModItems.RED_PICNIC_BASKET.get(),"Red Picnic Basket");
        translationBuilder.add(ModItems.ORANGE_PICNIC_BASKET.get(),"Orange Picnic Basket");
        translationBuilder.add(ModItems.YELLOW_PICNIC_BASKET.get(),"Yellow Picnic Basket");
        translationBuilder.add(ModItems.LIME_PICNIC_BASKET.get(),"Lime Picnic Basket");
        translationBuilder.add(ModItems.GREEN_PICNIC_BASKET.get(),"Green Picnic Basket");
        translationBuilder.add(ModItems.CYAN_PICNIC_BASKET.get(),"Cyan Picnic Basket");
        translationBuilder.add(ModItems.LIGHT_BLUE_PICNIC_BASKET.get(),"Light Blue Picnic Basket");
        translationBuilder.add(ModItems.BLUE_PICNIC_BASKET.get(),"Blue Picnic Basket");
        translationBuilder.add(ModItems.PURPLE_PICNIC_BASKET.get(),"Purple Picnic Basket");
        translationBuilder.add(ModItems.MAGENTA_PICNIC_BASKET.get(),"Magenta Picnic Basket");
        translationBuilder.add(ModItems.PINK_PICNIC_BASKET.get(),"Pink Picnic Basket");
        translationBuilder.add("stat.muffins_picnic.open_picnic_basket","Picnic Basket Opened");
    }

    static class ThaiLangDataGen extends FabricLanguageProvider {
        protected ThaiLangDataGen(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
            super(dataOutput,"th_th",registryLookup);
        }

        @Override
        public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
            translationBuilder.add("muffins_picnic.container.basket","ตะกร้าปิกนิก");
            translationBuilder.add(ModItems.WHITE_PICNIC_BASKET.get(),"ตะกร้าปิกนิกสีขาว");
            translationBuilder.add(ModItems.LIGHT_GRAY_PICNIC_BASKET.get(),"ตะกร้าปิกนิกสีเทาอ่อน");
            translationBuilder.add(ModItems.GRAY_PICNIC_BASKET.get(),"ตะกร้าปิกนิกสีเทา");
            translationBuilder.add(ModItems.BLACK_PICNIC_BASKET.get(),"ตะกร้าปิกนิกสีดำ");
            translationBuilder.add(ModItems.BROWN_PICNIC_BASKET.get(),"ตะกร้าปิกนิกสีน้ำตาล");
            translationBuilder.add(ModItems.RED_PICNIC_BASKET.get(),"ตะกร้าปิกนิกสีแดง");
            translationBuilder.add(ModItems.ORANGE_PICNIC_BASKET.get(),"ตะกร้าปิกนิกสีส้ม");
            translationBuilder.add(ModItems.YELLOW_PICNIC_BASKET.get(),"ตะกร้าปิกนิกสีเหลือง");
            translationBuilder.add(ModItems.LIME_PICNIC_BASKET.get(),"ตะกร้าปิกนิกสีเขียวอ่อน");
            translationBuilder.add(ModItems.GREEN_PICNIC_BASKET.get(),"ตะกร้าปิกนิกสีเขียว");
            translationBuilder.add(ModItems.CYAN_PICNIC_BASKET.get(),"ตะกร้าปิกนิกสีฟ้าคราม");
            translationBuilder.add(ModItems.LIGHT_BLUE_PICNIC_BASKET.get(),"ตะกร้าปิกนิกสีฟ้า");
            translationBuilder.add(ModItems.BLUE_PICNIC_BASKET.get(),"ตะกร้าปิกนิกสีน้ำเงิน");
            translationBuilder.add(ModItems.PURPLE_PICNIC_BASKET.get(),"ตะกร้าปิกนิกสีม่วง");
            translationBuilder.add(ModItems.MAGENTA_PICNIC_BASKET.get(),"ตะกร้าปิกนิกสีบานเย็น");
            translationBuilder.add(ModItems.PINK_PICNIC_BASKET.get(),"ตะกร้าปิกนิกสีชมพู");
            translationBuilder.add("stat.muffins_picnic.open_picnic_basket","เปิดตะกร้าปิคนิค");
        }
    }
}
