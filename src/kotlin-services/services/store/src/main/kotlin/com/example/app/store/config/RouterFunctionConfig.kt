package com.example.app.store.config

import com.example.app.store.adapter.input.web.StaffManagementRestAdapter
import com.example.app.store.adapter.input.web.StaffSearchRestAdapter
import com.example.app.store.adapter.input.web.StoreManagementRestAdapter
import com.example.app.store.adapter.input.web.StoreSearchRestAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class RouterFunctionConfig {
    @Bean
    fun routeStore(
        storeManagementRestAdapter: StoreManagementRestAdapter,
        storeSearchRestAdapter: StoreSearchRestAdapter,
    ): RouterFunction<ServerResponse> {
        return RouterFunctions.route()
            .POST("/store/stores", storeManagementRestAdapter::addStore)
            .PUT("/store/stores/{storeId}", storeManagementRestAdapter::updateStore)
            .DELETE("/store/stores/{storeId}", storeManagementRestAdapter::deleteStore)
            .GET("/store/stores", storeSearchRestAdapter::searchStores)
            .GET("/store/stores/{storeId}", storeSearchRestAdapter::searchStoreById)
            .build()
    }

    @Bean
    fun routeStaff(
        staffManagementRestAdapter: StaffManagementRestAdapter,
        staffSearchRestAdapter: StaffSearchRestAdapter
    ): RouterFunction<ServerResponse> {
        return RouterFunctions.route()
            .POST("/store/staffs", staffManagementRestAdapter::addStaff)
            .PUT("/store/staffs/{staffId}", staffManagementRestAdapter::updateStaff)
            .DELETE("/store/staffs/{staffId}", staffManagementRestAdapter::deleteStaff)
            .POST("/store/staffs/{staffId}/stores/{storeId}", staffManagementRestAdapter::assignStaffToStore)
            .DELETE("/store/staffs/{staffId}/stores/{storeId}", staffManagementRestAdapter::unassignStaffFromStore)
            .GET("/store/staffs", staffSearchRestAdapter::searchStaffs)
            .GET("/store/staffs/{staffId}", staffSearchRestAdapter::searchStaffById)
            .build()
    }
}
