package com.cd.basic.service.serviceImpl;
import java.util.List;
import com.cd.basic.dao.AttRecordWorkerDao;
import com.cd.basic.pojo.domain.AttRecordWorker;
import com.cd.common.Assist;
import com.cd.basic.service.AttRecordWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AttRecordWorkerServiceImpl implements AttRecordWorkerService{
    @Autowired
    private AttRecordWorkerDao attRecordWorkerDao;
    @Override
    public long getAttRecordWorkerRowCount(Assist assist){
        return attRecordWorkerDao.getAttRecordWorkerRowCount(assist);
    }
    @Override
    public List<AttRecordWorker> selectAttRecordWorker(Assist assist){
        return attRecordWorkerDao.selectAttRecordWorker(assist);
    }
    @Override
    public AttRecordWorker selectAttRecordWorkerByObj(AttRecordWorker obj){
        return attRecordWorkerDao.selectAttRecordWorkerByObj(obj);
    }
    @Override
    public AttRecordWorker selectAttRecordWorkerById(Long id){
        return attRecordWorkerDao.selectAttRecordWorkerById(id);
    }
    @Override
    public int insertAttRecordWorker(AttRecordWorker value){
        return attRecordWorkerDao.insertAttRecordWorker(value);
    }
    @Override
    public int insertNonEmptyAttRecordWorker(AttRecordWorker value){
        return attRecordWorkerDao.insertNonEmptyAttRecordWorker(value);
    }
    @Override
    public int insertAttRecordWorkerByBatch(List<AttRecordWorker> value){
        return attRecordWorkerDao.insertAttRecordWorkerByBatch(value);
    }
    @Override
    public int deleteAttRecordWorkerById(Long id){
        return attRecordWorkerDao.deleteAttRecordWorkerById(id);
    }
    @Override
    public int deleteAttRecordWorker(Assist assist){
        return attRecordWorkerDao.deleteAttRecordWorker(assist);
    }
    @Override
    public int updateAttRecordWorkerById(AttRecordWorker enti){
        return attRecordWorkerDao.updateAttRecordWorkerById(enti);
    }
    @Override
    public int updateAttRecordWorker(AttRecordWorker value, Assist assist){
        return attRecordWorkerDao.updateAttRecordWorker(value,assist);
    }
    @Override
    public int updateNonEmptyAttRecordWorkerById(AttRecordWorker enti){
        return attRecordWorkerDao.updateNonEmptyAttRecordWorkerById(enti);
    }
    @Override
    public int updateNonEmptyAttRecordWorker(AttRecordWorker value, Assist assist){
        return attRecordWorkerDao.updateNonEmptyAttRecordWorker(value,assist);
    }

    public AttRecordWorkerDao getAttRecordWorkerDao() {
        return this.attRecordWorkerDao;
    }

    public void setAttRecordWorkerDao(AttRecordWorkerDao attRecordWorkerDao) {
        this.attRecordWorkerDao = attRecordWorkerDao;
    }

}