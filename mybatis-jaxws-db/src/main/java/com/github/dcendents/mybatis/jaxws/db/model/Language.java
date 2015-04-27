package com.github.dcendents.mybatis.jaxws.db.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.github.dcendents.mybatis.jaxws.db.model.gen.LanguageGen;

@NoArgsConstructor
@ToString(callSuper = true)
// Do not use any added fields for equals and hashcode
@EqualsAndHashCode(callSuper = true, of = { })
public class Language extends LanguageGen {

	private static final long serialVersionUID = 1L;

}
