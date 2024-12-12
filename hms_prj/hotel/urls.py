from django.urls import path
from . import views

urlpatterns = [
    path('login/', views.login_view, name='login'),
    path('register/', views.register_view, name='register'),
    path('hotels/', views.hotels_list, name='hotels_list'),
    path('hotels/add/', views.add_hotel, name='add_hotel'),
    path('hotels/welcome/', views.welcome_view, name='welcome'),

]
