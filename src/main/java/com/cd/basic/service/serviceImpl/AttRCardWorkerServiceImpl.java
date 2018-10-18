package com.cd.basic.service.serviceImpl;
import java.util.List;
import com.cd.basic.dao.AttRCardWorkerDao;
import com.cd.basic.pojo.domain.AttRCardWorker;
import com.cd.common.Assist;
import com.cd.basic.service.AttRCardWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AttRCardWorkerServiceImpl implements AttRCardWorkerService{
    @Autowired
    private AttRCardWorkerDao attRCardWorkerDao;
    @Override
    public long getAttRCardWorkerRowCount(Assist assist){
        return attRCardWorkerDao.getAttRCardWorkerRowCount(assist);
    }
    @Override
    public List<AttRCardWorker> selectAttRCardWorker(Assist assist){
        return attRCardWorkerDao.selectAttRCardWorker(assist);
    }
    @Override
    public AttRCardWorker selectAttRCardWorkerByObj(AttRCardWorker obj){
        return attRCardWorkerDao.selectAttRCardWorkerByObj(obj);
    }
    @Override
    public AttRCardWorker selectAttRCardWorkerById(Long id){
        return attRCardWorkerDao.selectAttRCardWorkerById(id);
    }
    @Override
    public int insertAttRCardWorker(AttRCardWorker value){
        return attRCardWorkerDao.insertAttRCardWorker(value);
    }
    @Override
    public int insertNonEmptyAttRCardWorker(AttRCardWorker value){
        return attRCardWorkerDao.insertNonEmptyAttRCardWorker(value);
    }
    @Override
    public int insertAttRCardWorkerByBatch(List<AttRCardWorker> value){
        return attRCardWorkerDao.insertAttRCardWorkerByBatch(value);
    }
    @Override
    public int deleteAttRCardWorkerById(Long id){
        return attRCardWorkerDao.deleteAttRCardWorkerById(id);
    }
    @Override
    public int deleteAttRCardWorker(Assist assist){
        return attRCardWorkerDao.deleteAttRCardWorker(assist);
    }
    @Override
    public int updateAttRCardWorkerById(AttRCardWorker enti){
        return attRCardWorkerDao.updateAttRCardWorkerById(enti);
    }
    @Override
    public int updateAttRCardWorker(AttRCardWorker value, Assist assist){
        return attRCardWorkerDao.updateAttRCardWorker(value,assist);
    }
    @Override
    public int updateNonEmptyAttRCardWorkerById(AttRCardWorker enti){
        return attRCardWorkerDao.updateNonEmptyAttRCardWorkerById(enti);
    }
    @Override
    public int updateNonEmptyAttRCardWorker(AttRCardWorker value, Assist assist){
        return attRCardWorkerDao.updateNonEmptyAttRCardWorker(value,assist);
    }

    public AttRCardWorkerDao getAttRCardWorkerDao() {
        return this.attRCardWorkerDao;
    }

    public void setAttRCardWorkerDao(AttRCardWorkerDao attRCardWorkerDao) {
        this.attRCardWorkerDao = attRCardWorkerDao;
    }

}