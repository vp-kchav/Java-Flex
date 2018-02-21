package com.vecteurplus.inventory.event {
	
	import com.vecteurplus.inventory.model.Category;
	
	import flash.events.Event;
	
	public class CategoryEvent extends Event {
		
		public static const SAVE_CATEGORY:String = "saveCategory";
		public static const UPDATE_CATEGORY:String = "updateCategory";
		public static const DELETE_CATEGORY:String = "deleteCategory";
		public static const SEARCH_CATEGORY:String = "searchCategory";
		public static const GET_SELECTED_CATEGORY:String = "getSelectedCategory";
		public static const DISPLAY_SELECTED_CATEGORY:String = "displaySelectedCategory";
		public static const GET_ALL_CATEGORIES:String = "getAllCategories";
		
		private var _category:Category;
		private var _categoryId:int;
		
		public function CategoryEvent(type:String, bubbles:Boolean = true, cancelable:Boolean = false) {
			super(type, bubbles, cancelable);
		} 
		
		public function set categoryId(id:int):void {
			_categoryId = id;
		}
		
		public function get categoryId():int {
			return _categoryId;
		}
		
		public function set category(cat:Category):void {
			_category = cat;
		}
		
		public function get category():Category {
			return _category;
		}
	}
}