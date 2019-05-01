%%
% 无线信号强度随位置的变化
rssi1 = [-60 -73 -79 -81 -85 -88 -88 -93 -91 -84 -98];
rssi2 = [-100 -79 -76 -74 -72 -81 -72 -76 -77 -72 -67];
rssi3 = [-79 -74 -78 -73 -74 -74 -75 -80 -78 -84 -82]
plot(rssi1,'-*');
hold on;
plot(rssi2,'-o');
plot(rssi3,'-^');
legend('路由器1','路由器2','路由器3');

%%
%无线信号强度在某一点的分布情况
% data =[-58 -63 -69 -62 -60 -62 -59 -60 -59 -60 -60 -57 -60 -61 -60 -59 -58 -61 -60 -60 -60 -59 -59 -60 -61 -60 -59 -60 -60 -60];
% [y,x]=hist(data,100);     
% y=y/length(data)/mean(diff(x));  
% bar(x,y,1);

%%
%不同参考点可接入节点数量的变化
% data1 = train_data(:,3:end);
% count_list = [];
% for i = 1:50
%     count = 0;
%     for j = 1:44
%         if data1(i,j) == -100
%             ;
%         else
%             count = count+1;
%         end
%     end
%     count_list = [count_list count];
% end
% plot(count_list,'-o');

% count_list=[12
% 13
% 13
% 15
% 14
% 14
% 10
% 11
% 15
% 17
% 16
% 17
% 19
% 22
% 10
% 11
% 13
% 16
% 14
% 14
% 15
% 18
% 17
% 15
% 13
% 15
% 18
% 23
% 29
% 24
% 28
% 29
% 33
% 32
% 37
% 41
% 40
% 46
% 25
% 22
% 25
% 28
% 32
% 33
% 31
% 30
% 37
% 42
% 39];
% plot(count_list,'-o');

%同一点处可接入节点数量的变化
% data2 = test_data(1:10,3:end);
% count_list = [];
% for i = 1:10
%     count = 0;
%     for j = 1:44
%         if data2(i,j) == -100
%             ;
%         else
%             count = count+1;
%         end
%     end
%     count_list = [count_list count];
% end
% plot(count_list,'-o');
% data2 = test_data(51:60,3:end);
% count_list = [];
% for i = 1:10
%     count = 0;
%     for j = 1:44
%         if data2(i,j) == -100
%             ;
%         else
%             count = count+1;
%         end
%     end
%     count_list = [count_list count];
% end
% hold on;
% plot(count_list,'-*');
% legend('参考点1','参考点2');
% set(gca,'YLim',[5 13]);
% 
% 
% rssi_count1 = [17
% 19
% 10
% 11
% 13
% 15
% 15
% 18
% 20
% 20
% 20
% 21
% 22
% 22
% 22
% 22
% 22
% 22
% 21
% 22
% 21
% 22
% 20
% 19
% 18
% 18
% 19
% 18
% 18
% 18];
% rssi_count2 = [22
% 22
% 15
% 16
% 18
% 19
% 21
% 22
% 22
% 22
% 23
% 23
% 22
% 23
% 23
% 24
% 23
% 24
% 24
% 24
% 24
% 27
% 28
% 28
% 29
% 29
% 29
% 29
% 27
% 27];
% plot(rssi_count1,'-o');
% hold on;
% plot(rssi_count2,'-o');
% legend('参考点1','参考点2');