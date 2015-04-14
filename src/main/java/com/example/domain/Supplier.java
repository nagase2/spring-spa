package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="supplier")//テーブル名（＝クラス名）

@Data
@NoArgsConstructor //JPAの仕様で、EntityClassには引数のないデフォルトコンストラクタを作る必要がある。
@AllArgsConstructor
public class Supplier {
	@Id
	@GeneratedValue //主キーがDBで自動裁判されることをこのアノテーションで示す
	private Integer id;
	@Column(nullable = false) //このカラムの制約事項を指定
	private String firstName;
	@Column(nullable =false)
	private String lastName;
	private String tel;
}
