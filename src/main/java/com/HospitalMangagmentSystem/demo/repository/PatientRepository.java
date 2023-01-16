package com.HospitalMangagmentSystem.demo.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.stereotype.Repository;
	import com.HospitalMangagmentSystem.demo.domain.Patients;

	import java.util.List;

@Repository
	public interface PatientRepository extends JpaRepository<Patients,Integer>{

	@Query("SELECT a FROM Patients a WHERE a.status = ?1")
   	List<Patients> findByName(String status);

	@Query("SELECT a FROM Patients a WHERE a.roomNo = ?1")
	List<Patients> findByRoom(String roomNo);

	@Query("SELECT a FROM Patients a WHERE a.userid = ?1")
	List<Patients> findByUserid(int userid);

	@Query("SELECT a FROM Patients a WHERE a.room = ?1")
	List<Patients> findByRooms(String room);

	@Query("SELECT a FROM Patients a WHERE a.doctorid = ?1 AND ((a.lab=0 AND a.rad = 0)AND (a.status='inprogress'))")
	List<Patients> findByNames(int doctorid);

	@Query("SELECT a FROM Patients a WHERE a.lab = ?1")
	List<Patients> findByNamesLab(int lab);

	@Query("SELECT a FROM Patients a WHERE a.rad = ?1")
	List<Patients> findByNamesRad(int rad);


	@Query("SELECT a FROM Patients a WHERE a.rad = 1 OR a.rad=2")
	List<Patients> findByNamesRadTato();

	@Query("SELECT a FROM Patients a WHERE a.lab = 1 OR a.lab=2")
	List<Patients> findByNamesLabTato();

	@Query("SELECT a FROM Patients a WHERE (a.rad = 1 OR a.lab=1) AND a.doctorid = ?1")
	List<Patients> findByNamesTod(int doctorid);

	@Query("SELECT a FROM Patients a WHERE ((a.rad = 2 OR a.lab=2) OR (a.status='NORL')) AND a.doctorid = ?1")
	List<Patients> findByNamesTad(int doctorid);
}



