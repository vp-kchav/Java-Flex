package com.vecteurplus.inventory.model {
	
	import flash.utils.IDataInput;
	import flash.utils.IDataOutput;
	import flash.utils.IExternalizable;
	
	import org.granite.collections.IPersistentCollection;
	import org.granite.meta;
	
	use namespace meta;
	
	[Bindable]
	public class CategoryBase implements IExternalizable {
		
		private var _initialized:Boolean = true;
		private var _detachedState:String = null;
		
		private var _code:String;
		private var _id:int;
		private var _name:String;
		
		meta function isInitialized(name:String = null):Boolean {
			if(!name)
				return _initialized;
			var property:* = this[name];
			return (
				(!(property is Category) || (property as Category).meta::isInitialized()) &&
				(!(property is IPersistentCollection) || (property as IPersistentCollection).isInitialized())
			);
		}
		
		public function CategoryBase(){
		}
		
		public function set code(c:String):void {
			_code = c;
		}
		
		public function get code():String {
			return _code;
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
		
		public function toString():String {
			return "Category[id = "+ id + ", name = " + name + ", code = " + code + "]";
		}
		
		public function readExternal(input:IDataInput):void {
			_initialized = input.readObject() as Boolean;
			_detachedState = input.readObject() as String;
			if(meta::isInitialized()) {
				_code = input.readObject() as String;
				_id = input.readObject() as int;
				_name = input.readObject() as String;
			}
			else {
				_id = input.readObject() as int;
			}
		}
		
		public function writeExternal(output:IDataOutput):void {
			output.writeObject(_initialized);
			output.writeObject(_detachedState);
			if(meta::isInitialized()) {
				output.writeObject(_code);
				output.writeObject(_id);
				output.writeObject(_name);
			}
			else {
				output.writeObject(_id);
			}
		}
	}
}