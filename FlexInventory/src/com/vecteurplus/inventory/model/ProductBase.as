package com.vecteurplus.inventory.model {
	
	import flash.utils.IDataInput;
	import flash.utils.IDataOutput;
	import flash.utils.IExternalizable;
	import org.granite.collections.IPersistentCollection;
	import org.granite.meta;
	
	use namespace meta;
	
	[Bindable]
	public class ProductBase implements IExternalizable {
		
		private var _initialized:Boolean = true;
		private var _detachedState:String = null;
		
		private var _category:Category;
		private var _code:String;
		private var _cost:Number;
		private var _description:String;
		private var _id:int;
		private var _name:String;
		private var _price:Number;
		
		public function ProductBase(){
		}
		
		meta function isInitialized(name:String = null):Boolean {
			if(!name)
				return _initialized;
			var property:* = this[name];
			return (
				(!(property is Product) || (property as Product).meta::isInitialized()) &&
				(!(property is IPersistentCollection) || (property as IPersistentCollection).isInitialized())
			);
		}
		
		public function set category(cat:Category):void {
			_category = cat;
		}
		
		public function get category():Category {
			return _category;
		}
		
		public function set code(c:String):void {
			_code = c;
		}
		
		public function get code():String {
			return _code;
		}
		
		public function set cost(c:Number):void {
			_cost = c;
		}
		
		public function get cost():Number {
			return _cost;
		}
		
		public function set description(desc:String):void {
			_description = desc;
		}
		
		public function get description():String {
			return _description;
		}
		
		public function set id(i:int):void {
			_id = i;
		}
		
		public function get id():int {
			return _id;
		}
		
		public function set name(n:String):void {
			_name = n;
		}
		
		public function get name():String {
			return _name;
		}
		
		public function set price(p:Number):void {
			_price = p;
		}
		
		public function get price():Number {
			return _price;
		}
		
		public function readExternal(input:IDataInput):void {
			_initialized = input.readObject() as Boolean;
			_detachedState = input.readObject() as String;
			if(meta::isInitialized()) {
				_category = input.readObject() as Category;
				_code = input.readObject() as String;
				_cost = function(obj:*):Number { return (obj is Number ? obj as Number : Number.NaN) } (input.readObject());
				_description = input.readObject() as String;
				_id = input.readObject() as int;
				_name = input.readObject() as String;
				_price = function(obj:*):Number { return (obj is Number ? obj as Number : Number.NaN) } (input.readObject());
			}
			else {
				_id = input.readObject() as int;
			}
		}
		
		public function writeExternal(output:IDataOutput):void {
			output.writeObject(_initialized);
			output.writeObject(_detachedState);
			if(meta::isInitialized()) {
				output.writeObject(_category);				
				output.writeObject(_code);
				output.writeObject(_cost);
				output.writeObject(_description);				
				output.writeObject(_id);
				output.writeObject(_name);
				output.writeObject(_price);
			}
			else {
				output.writeObject(_id);
			}
		}
	}
}