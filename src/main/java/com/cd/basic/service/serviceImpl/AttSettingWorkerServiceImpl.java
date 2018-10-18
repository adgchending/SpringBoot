package com.cd.basic.service.serviceImpl;
import java.util.List;
import com.cd.basic.dao.AttSettingWorkerDao;
import com.cd.basic.pojo.domain.AttSettingWorker;
import com.cd.common.Assist;
import com.cd.basic.service.AttSettingWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AttSettingWorkerServiceImpl implements AttSettingWorkerService{
    @Autowired
    private AttSettingWorkerDao attSettingWorkerDao;
    @Override
    public long getAttSettingWorkerRowCount(Assist assist){
        return attSettingWorkerDao.getAttSettingWorkerRowCount(assist);
    }
    @Override
    public List<AttSettingWorker> selectAttSettingWorker(Assist assist){
        return attSettingWorkerDao.selectAttSettingWorker(assist);
    }
    @Override
    public AttSettingWorker selectAttSettingWorkerByObj(AttSettingWorker obj){
        return attSettingWorkerDao.selectAttSettingWorkerByObj(obj);
    }
    @Override
    public AttSettingWorker selectAttSettingWorkerById(Long id){
        return attSettingWorkerDao.selectAttSettingWorkerById(id);
    }
    @Override
    public int insertAttSettingWorker(AttSettingWorker value){
        return attSettingWorkerDao.insertAttSettingWorker(value);
    }
    @Override
    public int insertNonEmptyAttSettingWorker(AttSettingWorker value){
        return attSettingWorkerDao.insertNonEmptyAttSettingWorker(value);
    }
    @Override
    public int insertAttSettingWorkerByBatch(List<AttSettingWorker> value){
        return attSettingWorkerDao.insertAttSettingWorkerByBatch(value);
    }
    @Override
    public int deleteAttSettingWorkerById(Long id){
        return attSettingWorkerDao.deleteAttSettingWorkerById(id);
    }
    @Override
    public int deleteAttSettingWorker(Assist assist){
        return attSettingWorkerDao.deleteAttSettingWorker(assist);
    }
    @Override
    public int updateAttSettingWorkerById(AttSettingWorker enti){
        return attSettingWorkerDao.updateAttSettingWorkerById(enti);
    }
    @Override
    public int updateAttSettingWorker(AttSettingWorker value, Assist assist){
        return attSettingWorkerDao.updateAttSettingWorker(value,assist);
    }
    @Override
    public int updateNonEmptyAttSettingWorkerById(AttSettingWorker enti){
        return attSettingWorkerDao.updateNonEmptyAttSettingWorkerById(enti);
    }
    @Override
    public int updateNonEmptyAttSettingWorker(AttSettingWorker value, Assist assist){
        return attSettingWorkerDao.updateNonEmptyAttSettingWorker(value,assist);
    }

    public AttSettingWorkerDao getAttSettingWorkerDao() {
        return this.attSettingWorkerDao;
    }

    public void setAttSettingWorkerDao(AttSettingWorkerDao attSettingWorkerDao) {
        this.attSettingWorkerDao = attSettingWorkerDao;
    }

}