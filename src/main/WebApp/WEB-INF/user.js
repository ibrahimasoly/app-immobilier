function deleteItem(productId) {
        if (confirm("Etes-vous sur de vouloir supprimer ce produit ?")) {
            $.ajax({
                type: 'POST',
                url: 'User',
                data: { productId: productId },
                success: function(response) {
                    // Actualiser la page ou effectuer d'autres actions après la suppression
                    window.location.reload();
                },
                error: function(error) {
                    console.error('Erreur lors de la suppression du produit:', error);
                }
            });
        }
    }