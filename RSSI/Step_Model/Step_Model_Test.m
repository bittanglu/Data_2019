clear all;
clear;
%测试数据测试
test_data = importdata('acc_data3.txt');
[w l] = size(test_data);
acc_error = test_data(:,1);
acc_average = test_data(:,2);
time = test_data(:,3);
%行走距离为36m
L = 60;
t = [];
%步数
n = w;
%计算每一步时间
for i =1:n-1
    t(i) = time(i+1) - time(i);
end
t =[t mean(t)];
%模型参数
% Weiberg模型：
% C = 0.4293;
% B=+0.0435;

% Kim模型：
% C =0.1665;
% B=+0.0024;

% Scarlet模型：
C =0.2636;
B=+0.0370;

% 线性模型：
% a = 0.0004659
% b = 0.0938
% c = 0.0484

x = [];
for i =1:n
%     Weiberg模型
%     x(i) =  nthroot(acc_error(i),4);
%     Kim模型
%     x(i) =  acc_average(i)/acc_error(i);
%     Scarlet模型
    x(i) =  nthroot(acc_average(i),3);       
end
t =[t mean(t)];
dis = 0;
step_list = [];
for i =1:n
    step = C * x(i) + B;
    step_list =[step_list step];
    dis = dis + C * x(i) + B;
end
error = L - dis
%% 线性模型
% x1 = t;
% x2 = acc_error;
% dis = 0;
% for i =1:n
%     dis = dis + a * x1(i) + b * x2(i) + c;
% end
% error = L - dis;