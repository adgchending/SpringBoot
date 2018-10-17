package com.cd.basic.service.serviceImpl;
import java.util.List;
import com.cd.basic.dao.AttSettingRestWorkerDao;
import com.cd.basic.pojo.domain.AttSettingRestWorker;
import com.cd.common.Assist;
import com.cd.basic.service.AttSettingRestWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AttSettingRestWorkerServiceImpl implements AttSettingRestWorkerService{
    @Autowired
    private AttSettingRestWorkerDao attSettingRestWorkerDao;
    @Override
    public long getAttSettingRestWorkerRowCount(Assist assist){
        return attSettingRestWorkerDao.getAttSettingRestWorkerRowCount(assist);
    }
    @Override
    public List<AttSettingRestWorker> selectAttSettingRestWorker(Assist assist){
        return attSettingRestWorkerDao.selectAttSettingRestWorker(assist);
    }
    @Override
    public AttSettingRestWorker selectAttSettingRestWorkerByObj(AttSettingRestWorker obj){
        return attSettingRestWorkerDao.selectAttSettingRestWorkerByObj(obj);
    }
    @Override
    public AttSettingRestWorker selectAttSettingRestWorkerById(Long id){
        return attSettingRestWorkerDao.selectAttSettingRestWorkerById(id);
    }
    @Override
    public int insertAttSettingRestWorker(AttSettingRestWorker value){
        return attSettingRestWorkerDao.insertAttSettingRestWorker(value);
    }
    @Override
    public int insertNonEmptyAttSettingRestWorker(AttSettingRestWorker value){
        return attSettingRestWorkerDao.insertNonEmptyAttSettingRestWorker(value);
    }
    @Override
    public int insertAttSettingRestWorkerByBatch(List<AttSettingRestWorker> value){
        return attSettingRestWorkerDao.insertAttSettingRestWorkerByBatch(value);
    }
    @Override
    public int deleteAttSettingRestWorkerById(Long id){
        return attSettingRestWorkerDao.deleteAttSettingRestWorkerById(id);
    }
    @Override
    public int deleteAttSettingRestWorker(Assist assist){
        return attSettingRestWorkerDao.deleteAttSettingRestWorker(assist);
    }
    @Override
    public int updateAttSettingRestWorkerById(AttSettingRestWorker enti){
        return attSettingRestWorkerDao.updateAttSettingRestWorkerById(enti);
    }
    @Override
    public int updateAttSettingRestWorker(AttSettingRestWorker value, Assist assist){
        return attSettingRestWorkerDao.updateAttSettingRestWorker(value,assist);
    }
    @Override
    public int updateNonEmptyAttSettingRestWorkerById(AttSettingRestWorker enti){
        return attSettingRestWorkerDao.updateNonEmptyAttSettingRestWorkerById(enti);
    }
    @Override
    public int updateNonEmptyAttSettingRestWorker(AttSettingRestWorker value, Assist assist){
        return attSettingRestWorkerDao.updateNonEmptyAttSettingRestWorker(value,assist);
    }

    public AttSettingRestWorkerDao getAttSettingRestWorkerDao() {
        return this.attSettingRestWorkerDao;
    }

    public void setAttSettingRestWorkerDao(AttSettingRestWorkerDao attSettingRestWorkerDao) {
        this.attSettingRestWorkerDao = attSettingRestWorkerDao;
    }

}