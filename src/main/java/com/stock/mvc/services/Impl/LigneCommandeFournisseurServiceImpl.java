
package com.stock.mvc.services.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.DAO.ILigneCommandeFournisseurDao;
import com.stock.mvc.entities.LigneCommandeFournisseur;
import com.stock.mvc.services.ILigneCommandeFournisseurService;

@Transactional
public class LigneCommandeFournisseurServiceImpl implements ILigneCommandeFournisseurService {
	
	private ILigneCommandeFournisseurDao dao;

	public void setDao(ILigneCommandeFournisseurDao dao) {
		this.dao = dao;
	}

	@Override
	public LigneCommandeFournisseur save(LigneCommandeFournisseur entity) {
		return dao.save(entity);
	}

	@Override
	public LigneCommandeFournisseur update(LigneCommandeFournisseur entity) {
		return dao.update(entity);
	}

	@Override
	public List<LigneCommandeFournisseur> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<LigneCommandeFournisseur> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public LigneCommandeFournisseur getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public LigneCommandeFournisseur findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public LigneCommandeFournisseur findOne(String[] paraName, Object[] parmvalue) {
		return dao.findOne(paraName, parmvalue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

		
}
