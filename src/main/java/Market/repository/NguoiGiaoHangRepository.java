package Market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import Market.model.NguoiGiaoHang;

public interface NguoiGiaoHangRepository extends JpaRepository<NguoiGiaoHang, String> {
    @Query(value = "select * from NGUOIGIAOHANG where MaNguoiGiaoHang = :maNguoiGiaoHang", nativeQuery = true)
    NguoiGiaoHang findByMaNguoiGiaoHang(@Param("maNguoiGiaoHang") String maNguoiGiaoHang);

    @Transactional
    @Modifying
    @Query(value = "delete from NGUOIGIAOHANG  where MaNguoiGiaoHang = :id", nativeQuery = true)
    void xoaNguoiGiaoHang(@Param("id") String id);

}
