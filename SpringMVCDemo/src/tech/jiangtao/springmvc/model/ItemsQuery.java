package tech.jiangtao.springmvc.model;

import java.util.List;

/**
 * @class: ItemsQuery </br>
 * @description: 自定义商品输出拓展的{@link items} </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 2017/3/26 下午11:35</br>
 * @version: 0.0.1 </br>
 **/
public class ItemsQuery {

    private ItemsCustom itemsCustom;

    private List<ItemsCustom> itemsCustoms;

    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }

    public List<ItemsCustom> getItemsCustoms() {
        return itemsCustoms;
    }

    public void setItemsCustoms(List<ItemsCustom> itemsCustoms) {
        this.itemsCustoms = itemsCustoms;
    }
}
