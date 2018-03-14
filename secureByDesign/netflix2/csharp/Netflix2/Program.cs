﻿using System;

namespace Netflix2
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Registration ---- ");
            Console.WriteLine("Identifier : ");
            var userId = Console.ReadLine();
            Console.WriteLine("Password : ");
            var password = Console.ReadLine();

            Register(userId, password);

            Console.WriteLine("Connection : ");
            Console.WriteLine("Identifier : ");
            userId = Console.ReadLine();
            Console.WriteLine("Password : ");
            password = Console.ReadLine();

            if (Login(userId, password))
            {
                Console.WriteLine($"Vous êtes connecté en tant que {userId} ");
                Console.WriteLine("Films : ");

                // List DVD HERE
                // Format
                // dvdId) dvdName
                Console.WriteLine("Selection : ");
                var dvdId = Console.ReadLine();

                Console.WriteLine("Quantity : ");
                var quantity = int.Parse(Console.ReadLine());

                Booking(dvdId, quantity, userId);

                Console.WriteLine($"Nombre de DVD : {quantity} , prix final: 8eur x {quantity} DVD = {quantity * 8}" +
                    $", Si vous en prenez un de plus : 7eur x {quantity + 1} DVD = {(quantity + 1) * 7} eur");
            }

            Console.ReadLine();
        }

        private static void Register(string userId, string password)
        {
        }

        private static bool Login(string userId, string password)
        {
            return true;
        }

        private static void Booking(string dvdId, int quantity, string userId)
        {
        }
    }
}
