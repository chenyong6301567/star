package com.hotyum.stars.biz.model;

/**
 * 
 * @author Croky.Zheng
 * 2016年8月12日
 */
public class Column {
		public Column(String name,String type,String comment) {
			this.name = name;
			this.type = type;
			this.comment = comment;
		}
		private String name;
		private String type;
		private String comment;
		
		
		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}

		public String getComment() {
			return comment;
		}


		public void setComment(String comment) {
			this.comment = comment;
		}


		public String toString() {
			return "columnName:" + name + ",columnType:" + type + ",comment:" + comment;
		}
}
