package Market.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import Market.model.Vung;
public interface VungRepository extends JpaRepository<Vung, String>  {

    @Query(value = "select * from vung where PhuongXa=(select PhuongXa_GH from gianhang where magianhang=:magianhang) and quanhuyen=(select quanhuyen_gh from gianhang where magianhang=:magianhang)", nativeQuery = true)
	Vung FindLoaiVung(@Param("magianhang") String magianhang);
}
