clear all;
clear;
train_data = importdata('acc_data1.txt');

acc_error = train_data(:,1);
acc_average = train_data(:,2);
time = train_data(:,3);
y = 0.6;
t = [];
%步数
n = 60;
%线性模型参数
k1 = 0.5;
k2 = 0.5;

for i =1:n-1
    t(i) = time(i+1) - time(i);
    y = [y 0.6*i];
end
%线性模型处理
y1 = y;
y2 = y;

t =[t mean(t)];
%% 三个非线性模型
for i =1:n
%     Weiberg模型
%     x(i) =  nthroot(acc_error(i),4);
%     Kim模型
    x(i) =  acc_average(i)/acc_error(i);
%     Scarlet模型
%     x(i) =  nthroot(acc_average(i),3);
end

k = 0.2;
dis = 0;
a = [];
for i =1:n
    dis = dis + k * x(i);
    a(i) = y(i)/dis * k;
end
C = mean(a)
x1 = mean(a) * x;
B = mean(0.6 - x1)

%% 线性模型
% k = 0.2;
% dis1 = 0;
% dis2 = 0;
% a1 = [];
% a2 = [];
% x1 = t;
% x2 = acc_error;
% for i =1:60
%     dis1 = dis1 + k * x1(i);
%     a1(i) = y1(i)/dis1 * k;
%     dis2 = dis2 + k * x2(i);
%     a2(i) = y2(i)/dis2 * k;
% end
% C1 = mean(a1);
% y1 = mean(a1) * x1;
% B1 = mean(0.6 - y1);
% C2 = mean(a2);
% y2 = mean(a2) * x2;
% B2 = mean(0.6 - y2);
% a = C1*k1;
% b = C2*k2;
% c = k1*B1+k2*B2;
% step = a * x1 + b * x2' +c;