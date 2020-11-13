package com.winism.winism.dao.search;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.winism.winism.model.wine.wineList;


public interface SearchDAO extends JpaRepository<wineList, String> {

	@Query("SELECT w FROM wineList w where (:KEYWORD is null or w.KONAME LIKE %:KEYWORD% or w.ENNAME LIKE %:KEYWORD%) AND"+
	"(:TYPE is null or w.TYPE = :TYPE) AND (:RECOMMANDATION is null or w.RECOMMANDATION LIKE %:RECOMMANDATION%) AND "+
	"((:PRICE1 is null) or (w.COST BETWEEN :PRICE1 AND :PRICE2)) AND ((:ALCOHOL1 is null) or (w.LAESTDEGREE BETWEEN :ALCOHOL1 AND :ALCOHOL2)) AND"+
	"(:RATING is null or w.RATING >= :RATING) AND (:SWEETNESS is null or w.SWEETNESS = :SWEETNESS) AND (:ACIDITY is null or w.ACIDITY = :ACIDITY) AND"+
	"(:TANNIN is null or w.TANNIN = :TANNIN) AND (:BODY is null or w.BODY = :BODY) ORDER BY COST")
	Page<wineList> findWithFilter(Pageable pageable, @Param("KEYWORD") String KEYWORD, @Param("TYPE") String TYPE,
	@Param("RECOMMANDATION") String RECOMMANDATION, @Param("PRICE1") String PRICE1, @Param("PRICE2") String PRICE,
	@Param("ALCOHOL1") String ALCOHOL1, @Param("ALCOHOL2") String ALCOHOL2, @Param("RATING") int rating,
	@Param("SWEETNESS") String SWEETNESS,@Param("ACIDITY") String ACIDITY, @Param("TANNIN") String TANNIN, @Param("BODY") String BODY);


}