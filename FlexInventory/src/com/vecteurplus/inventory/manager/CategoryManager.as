package com.vecteurplus.inventory.manager {
	
	import com.vecteurplus.inventory.model.Category;
	import flash.events.EventDispatcher;
	import mx.collections.ArrayCollection;
	
	public class CategoryManager extends EventDispatcher {
		
		private var _currentCategories:ArrayCollection;
		private var _updatedCategory:Category;
		private var _deletedCategory:Category;
		
		public function set currentCategories(categories:ArrayCollection):void {
			_currentCategories = categories;
		}
		
		[Bindable]
		public function get currentCategories():ArrayCollection {
			return _currentCategories;
		}
		
		public function storeCategories(categories:ArrayCollection):void {
			currentCategories = categories;
		}
		
		public function set updatedCategory(category:Category):void {
			_updatedCategory = category;
		}
		
		[Bindable]
		public function get updatedCategory():Category {
			return _updatedCategory;
		}
		
		public function storeUpdatedCategory(category:Category):void {
			updatedCategory = category;
		}
		
		public function set deletedCategory(category:Category):void {
			_deletedCategory = category;
		}
		
		[Bindable]
		public function get deletedCategory():Category {
			return _deletedCategory;
		}
		
		public function storeDeletedCategory(category:Category):void {
			deletedCategory = category;
		}
	}
}