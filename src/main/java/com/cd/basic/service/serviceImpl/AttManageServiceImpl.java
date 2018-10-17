package com.cd.basic.service.serviceImpl;
import java.util.List;
import com.cd.basic.dao.AttManageDao;
import com.cd.basic.pojo.domain.AttManage;
import com.cd.common.Assist;
import com.cd.basic.service.AttManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AttManageServiceImpl implements AttManageService{
    @Autowired
    private AttManageDao attManageDao;
    @Override
    public long getAttManageRowCount(Assist assist){
        return attManageDao.getAttManageRowCount(assist);
    }
    @Override
    public List<AttManage> selectAttManage(Assist assist){
        return attManageDao.selectAttManage(assist);
    }
    @Override
    public AttManage selectAttManageByObj(AttManage obj){
        return attManageDao.selectAttManageByObj(obj);
    }
    @Override
    public AttManage selectAttManageById(Long id){
        return attManageDao.selectAttManageById(id);
    }
    @Override
    public int insertAttManage(AttManage value){
        return attManageDao.insertAttManage(value);
    }
    @Override
    public int insertNonEmptyAttManage(AttManage value){
        return attManageDao.insertNonEmptyAttManage(value);
    }
    @Override
    public int insertAttManageByBatch(List<AttManage> value){
        return attManageDao.insertAttManageByBatch(value);
    }
    @Override
    public int deleteAttManageById(Long id){
        return attManageDao.deleteAttManageById(id);
    }
    @Override
    public int deleteAttManage(Assist assist){
        return attManageDao.deleteAttManage(assist);
    }
    @Override
    public int updateAttManageById(AttManage enti){
        return attManageDao.updateAttManageById(enti);
    }
    @Override
    public int updateAttManage(AttManage value, Assist assist){
        return attManageDao.updateAttManage(value,assist);
    }
    @Override
    public int updateNonEmptyAttManageById(AttManage enti){
        return attManageDao.updateNonEmptyAttManageById(enti);
    }
    @Override
    public int updateNonEmptyAttManage(AttManage value, Assist assist){
        return attManageDao.updateNonEmptyAttManage(value,assist);
    }

    public AttManageDao getAttManageDao() {
        return this.attManageDao;
    }

    public void setAttManageDao(AttManageDao attManageDao) {
        this.attManageDao = attManageDao;
    }

}