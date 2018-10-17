package com.cd.basic.service.serviceImpl;
import java.util.List;
import com.cd.basic.dao.AttTravelCountDao;
import com.cd.basic.pojo.domain.AttTravelCount;
import com.cd.common.Assist;
import com.cd.basic.service.AttTravelCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AttTravelCountServiceImpl implements AttTravelCountService{
    @Autowired
    private AttTravelCountDao attTravelCountDao;
    @Override
    public long getAttTravelCountRowCount(Assist assist){
        return attTravelCountDao.getAttTravelCountRowCount(assist);
    }
    @Override
    public List<AttTravelCount> selectAttTravelCount(Assist assist){
        return attTravelCountDao.selectAttTravelCount(assist);
    }
    @Override
    public AttTravelCount selectAttTravelCountByObj(AttTravelCount obj){
        return attTravelCountDao.selectAttTravelCountByObj(obj);
    }
    @Override
    public AttTravelCount selectAttTravelCountById(Long id){
        return attTravelCountDao.selectAttTravelCountById(id);
    }
    @Override
    public int insertAttTravelCount(AttTravelCount value){
        return attTravelCountDao.insertAttTravelCount(value);
    }
    @Override
    public int insertNonEmptyAttTravelCount(AttTravelCount value){
        return attTravelCountDao.insertNonEmptyAttTravelCount(value);
    }
    @Override
    public int insertAttTravelCountByBatch(List<AttTravelCount> value){
        return attTravelCountDao.insertAttTravelCountByBatch(value);
    }
    @Override
    public int deleteAttTravelCountById(Long id){
        return attTravelCountDao.deleteAttTravelCountById(id);
    }
    @Override
    public int deleteAttTravelCount(Assist assist){
        return attTravelCountDao.deleteAttTravelCount(assist);
    }
    @Override
    public int updateAttTravelCountById(AttTravelCount enti){
        return attTravelCountDao.updateAttTravelCountById(enti);
    }
    @Override
    public int updateAttTravelCount(AttTravelCount value, Assist assist){
        return attTravelCountDao.updateAttTravelCount(value,assist);
    }
    @Override
    public int updateNonEmptyAttTravelCountById(AttTravelCount enti){
        return attTravelCountDao.updateNonEmptyAttTravelCountById(enti);
    }
    @Override
    public int updateNonEmptyAttTravelCount(AttTravelCount value, Assist assist){
        return attTravelCountDao.updateNonEmptyAttTravelCount(value,assist);
    }

    public AttTravelCountDao getAttTravelCountDao() {
        return this.attTravelCountDao;
    }

    public void setAttTravelCountDao(AttTravelCountDao attTravelCountDao) {
        this.attTravelCountDao = attTravelCountDao;
    }

}