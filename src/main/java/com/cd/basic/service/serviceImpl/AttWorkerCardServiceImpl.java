package com.cd.basic.service.serviceImpl;
import java.util.List;
import com.cd.basic.dao.AttWorkerCardDao;
import com.cd.basic.pojo.domain.AttWorkerCard;
import com.cd.common.Assist;
import com.cd.basic.service.AttWorkerCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AttWorkerCardServiceImpl implements AttWorkerCardService{
    @Autowired
    private AttWorkerCardDao attWorkerCardDao;
    @Override
    public long getAttWorkerCardRowCount(Assist assist){
        return attWorkerCardDao.getAttWorkerCardRowCount(assist);
    }
    @Override
    public List<AttWorkerCard> selectAttWorkerCard(Assist assist){
        return attWorkerCardDao.selectAttWorkerCard(assist);
    }
    @Override
    public AttWorkerCard selectAttWorkerCardByObj(AttWorkerCard obj){
        return attWorkerCardDao.selectAttWorkerCardByObj(obj);
    }
    @Override
    public AttWorkerCard selectAttWorkerCardById(Long id){
        return attWorkerCardDao.selectAttWorkerCardById(id);
    }
    @Override
    public int insertAttWorkerCard(AttWorkerCard value){
        return attWorkerCardDao.insertAttWorkerCard(value);
    }
    @Override
    public int insertNonEmptyAttWorkerCard(AttWorkerCard value){
        return attWorkerCardDao.insertNonEmptyAttWorkerCard(value);
    }
    @Override
    public int insertAttWorkerCardByBatch(List<AttWorkerCard> value){
        return attWorkerCardDao.insertAttWorkerCardByBatch(value);
    }
    @Override
    public int deleteAttWorkerCardById(Long id){
        return attWorkerCardDao.deleteAttWorkerCardById(id);
    }
    @Override
    public int deleteAttWorkerCard(Assist assist){
        return attWorkerCardDao.deleteAttWorkerCard(assist);
    }
    @Override
    public int updateAttWorkerCardById(AttWorkerCard enti){
        return attWorkerCardDao.updateAttWorkerCardById(enti);
    }
    @Override
    public int updateAttWorkerCard(AttWorkerCard value, Assist assist){
        return attWorkerCardDao.updateAttWorkerCard(value,assist);
    }
    @Override
    public int updateNonEmptyAttWorkerCardById(AttWorkerCard enti){
        return attWorkerCardDao.updateNonEmptyAttWorkerCardById(enti);
    }
    @Override
    public int updateNonEmptyAttWorkerCard(AttWorkerCard value, Assist assist){
        return attWorkerCardDao.updateNonEmptyAttWorkerCard(value,assist);
    }

    public AttWorkerCardDao getAttWorkerCardDao() {
        return this.attWorkerCardDao;
    }

    public void setAttWorkerCardDao(AttWorkerCardDao attWorkerCardDao) {
        this.attWorkerCardDao = attWorkerCardDao;
    }

}