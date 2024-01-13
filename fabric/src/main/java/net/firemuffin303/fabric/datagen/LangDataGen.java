package net.firemuffin303.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.firemuffin303.omorbasket.common.registry.ModItems;

public class LangDataGen extends FabricLanguageProvider {
    protected LangDataGen(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("muffins_picnic.container.basket","Picnic Basket");
        translationBuilder.add(ModItems.WHITE_PICNIC_BASKET,"White Picnic Basket");
        translationBuilder.add(ModItems.LIGHT_GRAY_PICNIC_BASKET,"Light Gray Picnic Basket");
        translationBuilder.add(ModItems.GRAY_PICNIC_BASKET,"Gray Picnic Basket");
        translationBuilder.add(ModItems.BLACK_PICNIC_BASKET,"Black Picnic Basket");
        translationBuilder.add(ModItems.BROWN_PICNIC_BASKET,"Brown Picnic Basket");
        translationBuilder.add(ModItems.RED_PICNIC_BASKET,"Red Picnic Basket");
        translationBuilder.add(ModItems.ORANGE_PICNIC_BASKET,"Orange Picnic Basket");
        translationBuilder.add(ModItems.YELLOW_PICNIC_BASKET,"Yellow Picnic Basket");
        translationBuilder.add(ModItems.LIME_PICNIC_BASKET,"Lime Picnic Basket");
        translationBuilder.add(ModItems.GREEN_PICNIC_BASKET,"Green Picnic Basket");
        translationBuilder.add(ModItems.CYAN_PICNIC_BASKET,"Cyan Picnic Basket");
        translationBuilder.add(ModItems.LIGHT_BLUE_PICNIC_BASKET,"Light Blue Picnic Basket");
        translationBuilder.add(ModItems.BLUE_PICNIC_BASKET,"Blue Picnic Basket");
        translationBuilder.add(ModItems.PURPLE_PICNIC_BASKET,"Purple Picnic Basket");
        translationBuilder.add(ModItems.MAGENTA_PICNIC_BASKET,"Magenta Picnic Basket");
        translationBuilder.add(ModItems.PINK_PICNIC_BASKET,"Pink Picnic Basket");

    }

    static class ThaiLangDataGen extends FabricLanguageProvider {
        protected ThaiLangDataGen(FabricDataOutput dataOutput) {
            super(dataOutput,"th_th");
        }

        @Override
        public void generateTranslations(TranslationBuilder translationBuilder) {
            translationBuilder.add("muffins_picnic.container.basket","ตะกร้าปิกนิก");
            translationBuilder.add(ModItems.WHITE_PICNIC_BASKET,"ตะกร้าปิกนิกสีขาว");
            translationBuilder.add(ModItems.LIGHT_GRAY_PICNIC_BASKET,"ตะกร้าปิกนิกสีเทาอ่อน");
            translationBuilder.add(ModItems.GRAY_PICNIC_BASKET,"ตะกร้าปิกนิกสีเทา");
            translationBuilder.add(ModItems.BLACK_PICNIC_BASKET,"ตะกร้าปิกนิกสีดำ");
            translationBuilder.add(ModItems.BROWN_PICNIC_BASKET,"ตะกร้าปิกนิกสีน้ำตาล");
            translationBuilder.add(ModItems.RED_PICNIC_BASKET,"ตะกร้าปิกนิกสีแดง");
            translationBuilder.add(ModItems.ORANGE_PICNIC_BASKET,"ตะกร้าปิกนิกสีส้ม");
            translationBuilder.add(ModItems.YELLOW_PICNIC_BASKET,"ตะกร้าปิกนิกสีเหลือง");
            translationBuilder.add(ModItems.LIME_PICNIC_BASKET,"ตะกร้าปิกนิกสีเขียวอ่อน");
            translationBuilder.add(ModItems.GREEN_PICNIC_BASKET,"ตะกร้าปิกนิกสีเขียว");
            translationBuilder.add(ModItems.CYAN_PICNIC_BASKET,"ตะกร้าปิกนิกสีฟ้าคราม");
            translationBuilder.add(ModItems.LIGHT_BLUE_PICNIC_BASKET,"ตะกร้าปิกนิกสีฟ้า");
            translationBuilder.add(ModItems.BLUE_PICNIC_BASKET,"ตะกร้าปิกนิกสีน้ำเงิน");
            translationBuilder.add(ModItems.PURPLE_PICNIC_BASKET,"ตะกร้าปิกนิกสีม่วง");
            translationBuilder.add(ModItems.MAGENTA_PICNIC_BASKET,"ตะกร้าปิกนิกสีบานเย็น");
            translationBuilder.add(ModItems.PINK_PICNIC_BASKET,"ตะกร้าปิกนิกสีชมพู");
        }
    }
}
