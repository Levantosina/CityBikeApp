package org.example.stations.StationsApp.dao;



import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;


/**
 * @author Levantosina
 */
@Component
public class testDao {
    private final EntityManager entityManager;

    public testDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


//    @Transactional(readOnly = true)
//    public Set<stationMay> testStations(){
//        Session session=entityManager.unwrap(Session.class);
//
//        List<stationMay> stationMays=session.createQuery("select p from  stationMay p",stationMay.class).getResultList();
//
//        for (stationMay stationMay: stationMays) {
//            System.out.println(stationMay.getDepartureStationName());
 //       }

//        Set<stationMay> stationMays=new HashSet<stationMay>(session.createQuery("select p.departureStationName from stationMay p ").getResultList());
//
//        for(stationMay stationMay:stationMays)
//            System.out.println(stationMay.getDepartureStationName());
//        return stationMays;
//    }

    //    @GetMapping("/test/{id}/{currentPage}")
//    public String test(Model model,@PathVariable("id") Integer id,@PathVariable("currentPage") int currentPage){
//
//        Page<StationsProjections>list = stationsService.findTest(id);
//        List<StationsProjections>list1= list.getContent();
//        long pages= list.getTotalPages();
//        long items = list.getTotalElements();
//        model.addAttribute("totalItems3", items);
//        model.addAttribute("totalPages3", pages);
//        model.addAttribute("currentPage3", currentPage);
//        model.addAttribute( "station3",list1);
//        return "stations/test";
//    }

}
