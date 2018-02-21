package com.vecteurplus.inventory.event {
	
	import com.vecteurplus.inventory.model.Product;
	
	import flash.events.Event;
	
	public class ProductEvent extends Event {
		
		public static const SAVE_PRODUCT:String = "saveProduct";
		public static const UPDATE_PRODUCT:String = "updateProduct";
		public static const DELETE_PRODUCT:String = "deleteProduct";
		public static const SEARCH_PRODUCT:String = "searchProduct";
		public static const GET_SELECTED_PRODUCT:String = "getSelectedProduct";
		public static const DISPLAY_SELECTED_PRODUCT:String = "displaySelectedProduct";
		public static const GET_ALL_PRODUCTS:String = "getAllProducts";
		
		private var _product:Product;
		private var _productId:int;
		
		public function ProductEvent(type:String, bubbles:Boolean = true, cancelable:Boolean = false) {
			super(type, bubbles, cancelable);
		} 
		
		public function set productId(id:int):void {
			_productId = id;
		}
		
		public function get productId():int {
			return _productId;
		}
		
		public function set product(pro:Product):void {
			_product = pro;
		}
		
		public function get product():Product {
			return _product;
		}
	}
}