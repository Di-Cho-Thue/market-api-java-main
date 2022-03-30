package Market.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Market.model.PhieuCanhBao;
public interface PhieuCanhBaoRepository extends JpaRepository<PhieuCanhBao, String>  {


    @Query(value = "select count(*) from PhieuCanhBao where MaGianHang = :magianhang",
			nativeQuery = true)
	Integer countPhieuCanhCao(@Param("magianhang") String magianhang);
}
