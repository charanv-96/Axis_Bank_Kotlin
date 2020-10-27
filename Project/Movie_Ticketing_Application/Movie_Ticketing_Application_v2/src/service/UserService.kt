package service

import model.User

interface UserService
{
    fun login() : User?
}
