package com.permission.service;

import java.util.List;

import com.permission.model.bo.ResourceBO;
import com.permission.model.vo.ResourceVM;
import com.permission.pojo.Resource;

public interface IResourceManagerService {

	public int GetResourceCntInOrg(int orgId);

	/**
	 * 加载一个节点下面的一个或全部Resources
	 * @return
	 */
	public ResourceBO Load(int categoryId, int pageindex, int pagesize);
	
	public List<Resource> LoadAll();

	/**
	 *  获取当前节点的所有下级节点
	 * @param orgId
	 * @return
	 */
	public List<Integer> GetSubOrgIds(int orgId);
	
    public Resource Find(int id);
    
    public void Delete(int id);
    
    public void AddOrUpdate(Resource model);
    
    /**
     * 获取带有授权状态的菜单列表
     * @param accessType
     * 授权类型，当前有RoleResource/UserResource
     * @param firstId
     * 当为RoleResource时，表示RoleId
     * 当为UserResource时，表示UserId
     * @param cId
     * @return
     */
    public List<ResourceVM> LoadWithAccess(String accessType, int firstId, int cId);
    
    /**
     * 为用户分配资源
     * @param userId
     * 用户ID
     * @param resIds
     * 资源ID数组
     */
    public void AssignResForUser(int userId, List<Integer> resIds);
    
    /**
     * 为角色分配资源
     * @param roleId
     * 角色ID
     * @param resIds
     * 资源ID数组
     */
    public void AssignResForRole(int roleId, List<Integer> resIds);
}
