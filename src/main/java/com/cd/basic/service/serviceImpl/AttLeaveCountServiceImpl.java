package com.cd.basic.service.serviceImpl;
import java.util.List;
import com.cd.basic.dao.AttLeaveCountDao;
import com.cd.basic.pojo.domain.AttLeaveCount;
import com.cd.common.Assist;
import com.cd.basic.service.AttLeaveCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AttLeaveCountServiceImpl implements AttLeaveCountService{
    @Autowired
    private AttLeaveCountDao attLeaveCountDao;
    @Override
    public long getAttLeaveCountRowCount(Assist assist){
        return attLeaveCountDao.getAttLeaveCountRowCount(assist);
    }
    @Override
    public List<AttLeaveCount> selectAttLeaveCount(Assist assist){
        return attLeaveCountDao.selectAttLeaveCount(assist);
    }
    @Override
    public AttLeaveCount selectAttLeaveCountByObj(AttLeaveCount obj){
        return attLeaveCountDao.selectAttLeaveCountByObj(obj);
    }
    @Override
    public AttLeaveCount selectAttLeaveCountById(Long id){
        return attLeaveCountDao.selectAttLeaveCountById(id);
    }
    @Override
    public int insertAttLeaveCount(AttLeaveCount value){
        return attLeaveCountDao.insertAttLeaveCount(value);
    }
    @Override
    public int insertNonEmptyAttLeaveCount(AttLeaveCount value){
        return attLeaveCountDao.insertNonEmptyAttLeaveCount(value);
    }
    @Override
    public int insertAttLeaveCountByBatch(List<AttLeaveCount> value){
        return attLeaveCountDao.insertAttLeaveCountByBatch(value);
    }
    @Override
    public int deleteAttLeaveCountById(Long id){
        return attLeaveCountDao.deleteAttLeaveCountById(id);
    }
    @Override
    public int deleteAttLeaveCount(Assist assist){
        return attLeaveCountDao.deleteAttLeaveCount(assist);
    }
    @Override
    public int updateAttLeaveCountById(AttLeaveCount enti){
        return attLeaveCountDao.updateAttLeaveCountById(enti);
    }
    @Override
    public int updateAttLeaveCount(AttLeaveCount value, Assist assist){
        return attLeaveCountDao.updateAttLeaveCount(value,assist);
    }
    @Override
    public int updateNonEmptyAttLeaveCountById(AttLeaveCount enti){
        return attLeaveCountDao.updateNonEmptyAttLeaveCountById(enti);
    }
    @Override
    public int updateNonEmptyAttLeaveCount(AttLeaveCount value, Assist assist){
        return attLeaveCountDao.updateNonEmptyAttLeaveCount(value,assist);
    }

    public AttLeaveCountDao getAttLeaveCountDao() {
        return this.attLeaveCountDao;
    }

    public void setAttLeaveCountDao(AttLeaveCountDao attLeaveCountDao) {
        this.attLeaveCountDao = attLeaveCountDao;
    }

}